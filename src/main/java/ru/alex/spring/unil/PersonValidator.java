package ru.alex.spring.unil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.alex.spring.database.DAO.UserLibraryDAO;
import ru.alex.spring.database.domin.Person;


/**
 * @author Neil Alishev
 */
@Component
public class PersonValidator implements Validator {

    private final UserLibraryDAO personDAO;

    @Autowired
    public PersonValidator(UserLibraryDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (personDAO.getPersonByFullName((person.getName())).isPresent())
            errors.rejectValue("name", "", "Человек с таким именем уже существует");
    }
}