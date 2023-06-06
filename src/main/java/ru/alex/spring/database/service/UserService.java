package ru.alex.spring.database.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.alex.spring.database.DAO.ILibruaryDAO;
import ru.alex.spring.database.domin.Book;
import ru.alex.spring.database.domin.Person;

import java.util.List;
@Service
public class UserService implements IService<Person>{
    private final ILibruaryDAO<Person> iLibruaryDAO;

    public UserService(@Qualifier("userLibraryDAO") ILibruaryDAO iLibruaryDAO) {
        this.iLibruaryDAO = iLibruaryDAO;
    }
    @Override
    public void save(Person newObject) {
        iLibruaryDAO.save(newObject);
    }

    @Override
    public void update(Object data, Integer id, String actions) {
        iLibruaryDAO.update(data, id, actions);
    }

  /*  public void update(Person updateObject, Integer id) {
        iLibruaryDAO.update(updateObject, id);
    }*/

    @Override
    public void delete(Integer id) {
        iLibruaryDAO.delete(id);
    }

    @Override
    public Person showInfo(Integer id) {
        return iLibruaryDAO.showInfo(id);
    }

    @Override
    public List<Person> index() {
        return iLibruaryDAO.index();
    }
}
