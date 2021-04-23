package up.estoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import up.estoque.entities.Movimento;
import up.estoque.entities.ProdutoFilial;
import up.estoque.repositories.ProdutoFilialRepository;

@Service
public class PrecoService {

	@Autowired
	ProdutoFilialRepository produtoFilialRepository;
	
	public Movimento precoMedio(Movimento movimento) {
		
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
