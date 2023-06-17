package ru.alex.spring.database.service;

import org.springframework.stereotype.Service;
import ru.alex.spring.database.DAO.UserLibraryDAO;
import ru.alex.spring.database.model.Person;

import java.util.List;
@Service
public class UserService{
    private final UserLibraryDAO iLibruaryDAO;

    public UserService(UserLibraryDAO iLibruaryDAO) {
        this.iLibruaryDAO = iLibruaryDAO;
    }

    public void save(Person newObject) {
        iLibruaryDAO.save(newObject);
    }


    public void update(Object data, Integer id, String actions) {
        iLibruaryDAO.update(data, id, actions);
    }

  /*  public void update(Person updateObject, Integer id) {
        iLibruaryDAO.update(updateObject, id);
    }*/


    public void delete(Integer id) {
        iLibruaryDAO.delete(id);
    }

    public Person showInfo(Integer id) {
        return iLibruaryDAO.showInfo(id);
    }


    public List<Person> index() {
        return iLibruaryDAO.index();
    }
}
