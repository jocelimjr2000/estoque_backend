package up.estoque.resources;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.estoque.entities.Nota;
import up.estoque.errors.CustomErrors;
import up.estoque.services.NotaService;

@RestController
@RequestMapping("/nota")
public class NotaResource extends CustomErrors {

	@Autowired
	NotaService notaService;

	@PostMapping("/entrada")
	@ApiOperation(value = "Cadastrar nota de entrada")
	public ResponseEntity<Nota> entrada(@Valid @RequestBody Nota nota) {
//		try {

			return new ResponseEntity<>(notaService.processarEntrada(nota), HttpStatus.CREATED);

//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
	
	@PostMapping("/saida")
	@ApiOperation(value = "Cadastrar nota de saída")
	public ResponseEntity<Nota> saida(@Valid @RequestBody Nota nota) throws ValidationException {
		try {

			return new ResponseEntity<>(notaService.processarSaida(nota), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
