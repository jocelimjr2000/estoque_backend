package up.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import up.estoque.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
