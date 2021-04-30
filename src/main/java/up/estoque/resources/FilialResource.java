package up.estoque.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.estoque.entities.Endereco;
import up.estoque.entities.Filial;
import up.estoque.entities.Telefone;
import up.estoque.errors.CustomErrors;
import up.estoque.repositories.EnderecoRepository;
import up.estoque.repositories.FilialRepository;
import up.estoque.repositories.TelefoneRepository;
import up.estoque.requests.FilialRequest;
import up.estoque.requests.TelefoneRequest;

@RestController
@RequestMapping("/filial")
public class FilialResource extends CustomErrors {

	@Autowired
	FilialRepository filialRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	@PostMapping
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@ApiOperation(value = "Cadastrar Filial")
	public ResponseEntity<Filial> create(@Valid @RequestBody FilialRequest requestValidated) {
		try {
			
			// Salvar Endereço
			Endereco endereco = new Endereco(requestValidated);
			endereco = enderecoRepository.save(endereco);
			
			// Salvar Filial
			Filial filial = new Filial(requestValidated);
			filial.setEndereco(endereco);
			filial = filialRepository.save(filial);
			
			List<Telefone> listTelefones = new ArrayList<>();
			
			// Salvar Telefones
			for(TelefoneRequest telefoneRequest: requestValidated.getTelefones()) {
				
				Telefone telefone = new Telefone();
				telefone.setDdd(telefoneRequest.getDdd());
				telefone.setNumero(telefoneRequest.getNumero());
				telefone.setTipo(telefoneRequest.getTipo());
				telefone.setFilial(filial);
				
				telefone = telefoneRepository.save(telefone);
				
				listTelefones.add(telefone);
			}
			
			filial.setTelefones(listTelefones);
			
			return new ResponseEntity<>(filial, HttpStatus.CREATED);

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
