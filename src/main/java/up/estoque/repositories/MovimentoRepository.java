package up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import up.estoque.entities.Movimento;

public interface MovimentoRepository extends JpaRepository<Movimento, Long>{

}
