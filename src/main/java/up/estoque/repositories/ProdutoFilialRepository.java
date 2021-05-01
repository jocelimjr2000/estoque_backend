package up.estoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import up.estoque.entities.Filial;
import up.estoque.entities.Produto;
import up.estoque.entities.ProdutoFilial;

public interface ProdutoFilialRepository extends JpaRepository<ProdutoFilial, Long>{

	ProdutoFilial findByFilialAndProduto(Filial filial, Produto produto);
	
	List<ProdutoFilial> findByFilial(Filial filial);
}
