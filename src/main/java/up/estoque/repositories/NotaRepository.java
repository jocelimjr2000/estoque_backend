package up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import up.estoque.entities.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long>{

}
