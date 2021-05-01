package up.estoque.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.estoque.entities.Filial;
import up.estoque.errors.CustomErrors;
import up.estoque.repositories.FilialRepository;

@RestController
@RequestMapping("/filial")
public class FilialResource extends CustomErrors {

	@Autowired
	FilialRepository filialRepository;

	@PostMapping
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@ApiOperation(value = "Cadastrar Filial")
	public ResponseEntity<Filial> create(@Valid @RequestBody Filial filial) {
		try {

			filial = filialRepository.save(filial);

			return new ResponseEntity<>(filial, HttpStatus.CREATED);

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar Filiais")
	public ResponseEntity<List<Filial>> findAll() {
		try {

			List<Filial> result = filialRepository.findAll();

			if (result != null) {
				return new ResponseEntity<>(result, HttpStatus.OK);
			}

			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{codigo}")
	@ApiOperation(value = "Encontrar Filial")
	public ResponseEntity<Filial> findFilial(@PathVariable("codigo") Long codigo) {
		try {

			Filial filial = filialRepository.findByCodigo(codigo);

			if (filial != null) {
				return new ResponseEntity<>(filial, HttpStatus.OK);
			}

			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
