package up.estoque.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.estoque.entities.Filial;
import up.estoque.entities.ProdutoFilial;
import up.estoque.errors.CustomErrors;
import up.estoque.repositories.ProdutoFilialRepository;

@RestController
@RequestMapping("/produtofilial")
public class ProdutoFilialResource extends CustomErrors {

	@Autowired
	ProdutoFilialRepository produtoFilialRepository;

	@GetMapping("/{filial_codigo}")
	@ApiOperation(value = "Listar Produtos por Filial")
	public ResponseEntity<List<ProdutoFilial>> findAllByFilial(@PathVariable("filial_codigo") Long filial_codigo) {
		try {

			Filial filial = new Filial();
			filial.setCodigo(filial_codigo);

			List<ProdutoFilial> result = produtoFilialRepository.findByFilial(filial);

			if (result != null) {
				return new ResponseEntity<>(result, HttpStatus.OK);
			}

			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
