package up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import up.estoque.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	boolean existsByCodigoInterno(Long codigo);
	
}
