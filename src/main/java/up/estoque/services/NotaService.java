package up.estoque.services;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import up.estoque.entities.Filial;
import up.estoque.entities.Movimento;
import up.estoque.entities.Nota;
import up.estoque.entities.Produto;
import up.estoque.entities.ProdutoFilial;
import up.estoque.repositories.NotaRepository;
import up.estoque.repositories.ProdutoFilialRepository;

@Service
public class NotaService {

	@Autowired
	NotaRepository notaRepository;

	@Autowired
	ProdutoFilialRepository produtoFilialRepository;
	
	public List<Nota> findByFilial(){
		return notaRepository.findAll();
	}

	public Nota processarEntrada(Nota nota) {
		//nota.setMovimentacao("E");
		
		for (Movimento movimento : nota.getProdutoQtd()) {

			Long filial_id = movimento.getProdutoFilial().getFilial().getCodigo();
			Long produto_codigoInterno = movimento.getProdutoFilial().getProduto().getCodigoInterno();
			
			Filial filial = new Filial();
			filial.setCodigo(filial_id);
			
			Produto produto = new Produto();
			produto.setCodigoInterno(produto_codigoInterno);
			
			// Pesquisar dados do produto/filial
			ProdutoFilial produtoFilial = produtoFilialRepository.findByFilialAndProduto(filial, produto);
			
			// Não existe no banco
			if (produtoFilial == null) {
				movimento.getProdutoFilial().setCustoMedio(movimento.getPrecoUnitario());
				movimento.getProdutoFilial().setQtd(movimento.getQtdMovimentada());
			} else {

				// Existe no banco com estoque
				if (produtoFilial.getQtd() > 0) {

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

				} else {
					// Existe no banco porém sem estoque
					produtoFilial.setQtd(movimento.getQtdMovimentada());
					produtoFilial.setCustoMedio(movimento.getPrecoUnitario());
					movimento.setProdutoFilial(produtoFilial);
				}
			}

		}

		return notaRepository.save(nota);
	}
	
	public Nota processarSaida(Nota nota) throws ValidationException {
		//nota.setMovimentacao("S");
		
		for (Movimento movimento : nota.getProdutoQtd()) {

			Long filial_id = movimento.getProdutoFilial().getFilial().getCodigo();
			Long produto_codigoInterno = movimento.getProdutoFilial().getProduto().getCodigoInterno();
			
			Filial filial = new Filial();
			filial.setCodigo(filial_id);
			
			Produto produto = new Produto();
			produto.setCodigoInterno(produto_codigoInterno);
			
			// Pesquisar dados do produto/filial
			ProdutoFilial produtoFilial = produtoFilialRepository.findByFilialAndProduto(filial, produto);

			// Verificar se produto existe no banco
			if (produtoFilial == null) {
				throw new ValidationException("Produto filial não encontrado", "400");
				
			}
			
			// Verificar se a qtd movimentada é maior que a qtd em estoque
			if(movimento.getQtdMovimentada() > produtoFilial.getQtd()) {
				throw new ValidationException("qtd invalida", "400");
			}
			
			// Definir nova quantidade (qtd atual - qtd movimentada)
			produtoFilial.setQtd(produtoFilial.getQtd() - movimento.getQtdMovimentada());
			
			produtoFilial = produtoFilialRepository.save(produtoFilial);
			
			movimento.setProdutoFilial(produtoFilial);
		}

		return notaRepository.save(nota);
	}
	
}
