package up.estoque;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import up.estoque.entities.Filial;
import up.estoque.entities.Movimento;
import up.estoque.entities.Nota;
import up.estoque.entities.NotaTipo;
import up.estoque.entities.Produto;
import up.estoque.entities.ProdutoFilial;
import up.estoque.services.NotaService;

@SpringBootTest
public class NotaTests {

	@Autowired
	private NotaService notaService;

	@Test
	public void deveriaCadastrarNotaEntrada() throws Exception {
		
		Date data = new Date(System.currentTimeMillis());
		String numero = "123";
		String tipoCodigo = "EA";
		Double qtdMov = 10.0;
		Double precoUnit = 8.55;
		Long filialCodigo = (long) 1;
		Long produtoCodigo = (long) 2;
		
		Nota nota = new Nota();
		nota.setData(data);
		nota.setNumero(numero);
		
		NotaTipo tipo = new NotaTipo();
		tipo.setCodigo(tipoCodigo);
		nota.setTipo(tipo);
		
		List<Movimento> produtoQtd = new ArrayList<Movimento>();
		
		Movimento movimento = new Movimento();
		movimento.setQtdMovimentada(qtdMov);
		movimento.setPrecoUnitario(precoUnit);
		
		ProdutoFilial produtoFilial = new ProdutoFilial();
		Filial filial = new Filial();
		Produto produto = new Produto();
		
		filial.setCodigo(filialCodigo);
		produto.setCodigoInterno(produtoCodigo);
		
		produtoFilial.setFilial(filial);
		produtoFilial.setProduto(produto);
		
		movimento.setProdutoFilial(produtoFilial);
		
		produtoQtd.add(movimento);
		
		nota.setProdutoQtd(produtoQtd);
		
		Nota result = notaService.processarEntrada(nota);
		
		Movimento resultMov = result.getProdutoQtd().get(0);
		
		assertThat(result.getData()).isEqualTo(data);
		assertThat(result.getNumero()).isEqualTo(numero);
		assertThat(result.getTipo().getCodigo()).isEqualTo(tipoCodigo);
		assertThat(resultMov.getQtdMovimentada()).isEqualTo(qtdMov);
		assertThat(resultMov.getPrecoUnitario()).isEqualTo(precoUnit);
		assertThat(resultMov.getProdutoFilial().getFilial().getCodigo()).isEqualTo(filialCodigo);
		assertThat(resultMov.getProdutoFilial().getProduto().getCodigoInterno()).isEqualTo(produtoCodigo);
	}
}
