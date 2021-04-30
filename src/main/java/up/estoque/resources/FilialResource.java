package up.estoque.resources;



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
import up.estoque.entities.Filial;
import up.estoque.errors.CustomErrors;
import up.estoque.repositories.FilialRepository;
import up.estoque.requests.FilialRequest;

@RestController
@RequestMapping("/filial")
public class FilialResource extends CustomErrors {

	@Autowired
	FilialRepository filialRepository;
	
	
	@PostMapping
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@ApiOperation(value = "Cadastrar Filial")
	public ResponseEntity<Filial> create(@Valid @RequestBody FilialRequest requestValidated) {
		try {
			
			// Salvar Filial
			Filial filial = new Filial(requestValidated);
			filial = filialRepository.save(filial);
		
		
			return new ResponseEntity<>(filial, HttpStatus.CREATED);

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
