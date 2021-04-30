package up.estoque.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import up.estoque.entities.Categoria;
import up.estoque.entities.Filial;
import up.estoque.entities.Produto;
import up.estoque.entities.ProdutoFilial;
import up.estoque.errors.CustomErrors;
import up.estoque.repositories.CategoriaRepository;
import up.estoque.repositories.FilialRepository;
import up.estoque.repositories.ProdutoFilialRepository;
import up.estoque.repositories.ProdutoRepository;
import up.estoque.requests.ProdutoRequest;

@RestController
@RequestMapping("/produto")
public class ProdutoResource extends CustomErrors {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ProdutoFilialRepository produtoFilialRepository;
	
	@Autowired
	FilialRepository filialRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	@ApiOperation(value = "Cadastrar produto")
	public ResponseEntity<Produto> create(@Valid @RequestBody ProdutoRequest validatedRequest){
		try {
			
			Produto produto = new Produto(validatedRequest);
			
			Categoria categoria = categoriaRepository.findById(validatedRequest.getCategoria());

			produto.setCategoria(categoria);
			
			produtoRepository.save(produto);
			
			return new ResponseEntity<>(produto, HttpStatus.CREATED);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/{filial}")
//	@ApiOperation(value = "Listar produtos")
//	public ResponseEntity<List<Filial>> findAll(@PathVariable("filial") Long filial){
//		try {
//			
//			Optional<Filial> produtoFilial = filialRepository.findById(filial);
//			
//			
//			return new ResponseEntity<>(produtoFilial, HttpStatus.OK);
//			
//		}catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	// Listar
	// Editar
	
}
