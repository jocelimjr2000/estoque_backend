package up.estoque;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import up.estoque.entities.Categoria;
import up.estoque.entities.Produto;
import up.estoque.repositories.ProdutoRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EstoqueApplicationTests {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Test
	public void deveriaCadastrarProduto() throws Exception {
		
		long codigoInterno = 4;
		String codigoExterno = "cod004";
		String descricao = "Fanta Lata 350ml";
		String nome = "Fanta lata";
		String unidade = "unit";
		String categoriaCodigo = "P";
		
		Produto produto = new Produto();
		produto.setCodigoInterno(codigoInterno);
		produto.setCodigoExterno(codigoExterno);
		produto.setDescricao(descricao);
		produto.setNome(nome);
		produto.setUnidade(unidade);
		
		Categoria categoria = new Categoria();
		categoria.setCodigo(categoriaCodigo);
		produto.setCategoria(categoria);
		
		Produto result = produtoRepository.save(produto);
		
		assertThat(result.getCodigoInterno()).isEqualTo(codigoInterno);
		assertThat(result.getCodigoExterno()).isEqualTo(codigoExterno);
		assertThat(result.getDescricao()).isEqualTo(descricao);
		assertThat(result.getNome()).isEqualTo(nome);
		assertThat(result.getUnidade()).isEqualTo(unidade);
		assertThat(result.getCategoria().getCodigo()).isEqualTo(categoriaCodigo);
		
	}
	
}
