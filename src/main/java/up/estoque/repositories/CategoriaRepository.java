package up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import up.estoque.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findById(String id);
	
}
