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

import up.estoque.entities.Nota;
import up.estoque.errors.CustomErrors;
import up.estoque.repositories.NotaRepository;
import up.estoque.requests.NotaRequest;

@RestController
@RequestMapping("/nota")
public class NotaResource extends CustomErrors {

	@Autowired
	NotaRepository notaRepository;

	@PostMapping
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ResponseEntity<Nota> create(@Valid @RequestBody NotaRequest validatedRequest) {
		try {

			Nota nota = new Nota(validatedRequest);

			nota = notaRepository.save(nota);

			return new ResponseEntity<>(nota, HttpStatus.CREATED);

		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
