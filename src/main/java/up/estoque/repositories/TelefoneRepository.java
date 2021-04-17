package up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import up.estoque.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
