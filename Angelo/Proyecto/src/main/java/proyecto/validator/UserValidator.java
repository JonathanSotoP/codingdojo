package proyecto.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import proyecto.models.User;


@Component
public class UserValidator implements Validator {
	
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
	@Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirm", "Match");
        }         
    }
}
