package up.estoque.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import up.estoque.annotations.CheckExistsProduto;
import up.estoque.repositories.ProdutoRepository;

public class ProdutoValidator implements ConstraintValidator<CheckExistsProduto, Long> {

	@Autowired
	ProdutoRepository produtoRepository;

	private boolean inverse = false;
	
	@Override
	public void initialize(CheckExistsProduto constraintAnnotation) {
		this.inverse = constraintAnnotation.inverse();
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		
		if (value == null || value == 0) {
			return true;
		}
		
		boolean result = produtoRepository.existsByCodigoInterno(value);
		
		if(this.inverse == true) {
			if(result == true) {
				return false;
			}
			
			return true;
		}
		
		return result;
	}

}