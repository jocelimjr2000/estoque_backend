package up.estoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import up.estoque.entities.ProdutoFilial;

public interface ProdutoFilialRepository extends JpaRepository<ProdutoFilial, Long>{

	@Query(value = "SELECT * FROM ProdutoFilial WHERE filial_id = :filialId AND produto_codigoInterno = :produtoCodigoInterno", nativeQuery = true)
	ProdutoFilial findQtdByFilialAndProduto(@Param("filialId") Long filialId, @Param("produtoCodigoInterno") Long produtoCodigoInterno);
	
	List<ProdutoFilial> findByFilial(Long id);
}
