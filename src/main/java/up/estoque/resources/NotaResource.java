package up.estoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import up.estoque.entities.Movimento;
import up.estoque.entities.Nota;
import up.estoque.entities.ProdutoFilial;
import up.estoque.errors.CustomErrors;
import up.estoque.repositories.MovimentoRepository;
import up.estoque.repositories.NotaRepository;
import up.estoque.repositories.ProdutoFilialRepository;
import up.estoque.services.PrecoService;

@RestController
@RequestMapping("/nota")
public class NotaResource extends CustomErrors {

	@Autowired
	NotaRepository notaRepository;
	
	@Autowired
	MovimentoRepository movimentoRepository;

	@Autowired
	PrecoService precoService;
	
	@Autowired
	ProdutoFilialRepository produtoFilialRepository;
	
	@PostMapping
	public ResponseEntity<Nota> create(@RequestBody Nota nota) {
		try {

			for (Movimento movimento : nota.getProdutoQtd()) {
				
				Long filial_id = movimento.getProdutoFilial().getFilial().getId();
				Long produto_codigoInterno = movimento.getProdutoFilial().getProduto().getCodigoInterno();
				
				// Pesquisar dados do produto/filial
				ProdutoFilial produtoFilial = produtoFilialRepository.findQtdByFilialAndProduto(filial_id, produto_codigoInterno);
				
				// Não existe no banco
				if(produtoFilial == null) {
					movimento.getProdutoFilial().setCustoMedio(movimento.getPrecoUnitario());
					movimento.getProdutoFilial().setQtd(movimento.getQtdMovimentada());
				}else { 
					
					// Existe no banco com estoque
					if(produtoFilial.getQtd() > 0) {
						
						Double custoMedioAtual = produtoFilial.getCustoMedio();
						Double qtdAtual = produtoFilial.getQtd();
						Double valorEstoqueAtual = custoMedioAtual * qtdAtual;
						
						Double qtdNota = movimento.getQtdMovimentada();
						Double precoNota = movimento.getPrecoUnitario();
						Double valorNota = qtdNota * precoNota;
						
						Double valorTotal = valorEstoqueAtual + valorNota;
						Double qtdTotal = qtdAtual + qtdNota;
						
						Double custoMedio = valorTotal / qtdTotal;
						
						produtoFilial.setQtd(qtdTotal);
						produtoFilial.setCustoMedio(custoMedio);
						
						movimento.setProdutoFilial(produtoFilial);
						
					}else {
						// Existe no banco porém sem estoque
						produtoFilial.setQtd(movimento.getQtdMovimentada());
						produtoFilial.setCustoMedio(movimento.getPrecoUnitario());
						movimento.setProdutoFilial(produtoFilial);
					}
				}
				
			}
		
			nota = notaRepository.save(nota);
			
			return new ResponseEntity<>(nota, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}