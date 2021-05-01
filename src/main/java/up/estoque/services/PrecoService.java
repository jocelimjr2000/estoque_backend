package up.estoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import up.estoque.entities.Filial;
import up.estoque.entities.Movimento;
import up.estoque.entities.Produto;
import up.estoque.entities.ProdutoFilial;
import up.estoque.repositories.ProdutoFilialRepository;

@Service
public class PrecoService {

	@Autowired
	ProdutoFilialRepository produtoFilialRepository;
	
	public Movimento precoMedio(Movimento movimento) {
		
		Long filial_id = movimento.getProdutoFilial().getFilial().getCodigo();
		Long produto_codigoInterno = movimento.getProdutoFilial().getProduto().getCodigoInterno();
		
		Filial filial = new Filial();
		filial.setCodigo(filial_id);
		
		Produto produto = new Produto();
		produto.setCodigoInterno(produto_codigoInterno);
		
		// Pesquisar dados do produto/filial
		ProdutoFilial produtoFilial = produtoFilialRepository.findByFilialAndProduto(filial, produto);
		
		// Não existe no banco
		if(produtoFilial == null) {
			movimento.getProdutoFilial().setCustoMedio(movimento.getPrecoUnitario());
			movimento.getProdutoFilial().setQtd(movimento.getQtdMovimentada());
		}else { 
			
			// Existe no banco com estoque
			if(produtoFilial.getQtd() > 0) {
				
				
			}else {
				// Existe no banco porém sem estoque
				produtoFilial.setQtd(movimento.getQtdMovimentada());
				produtoFilial.setCustoMedio(movimento.getPrecoUnitario());
				movimento.setProdutoFilial(produtoFilial);
			}
		}
		
		return movimento;
	}
}
