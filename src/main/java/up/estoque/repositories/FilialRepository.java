package up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import up.estoque.entities.Filial;

public interface FilialRepository extends JpaRepository<Filial, Long> {

	Filial findByCodigo(Long codigo);
}
