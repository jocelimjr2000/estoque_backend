package up.estoque.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Teste {
	
	@GetMapping("/")
	public String teste() {
		return "teste";
	}
	
}
