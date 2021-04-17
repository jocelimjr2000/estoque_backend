package up.estoque.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import up.estoque.validators.ProdutoValidator;

@Constraint(validatedBy = ProdutoValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckExistsProduto {

	String message() default "Invalid product";
	boolean inverse() default false;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}