package ru.alex.spring.database.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.alex.spring.database.DAO.ILibruaryDAO;
import ru.alex.spring.database.domin.Book;

import java.util.List;
@Service
public class BookService implements IService<Book>{
    private final ILibruaryDAO<Book> iLibruaryDAO;

    public BookService(@Qualifier("bookLibraryDAO") ILibruaryDAO iLibruaryDAO) {
        this.iLibruaryDAO = iLibruaryDAO;
    }
    @Override
    public void save(Book newObject) {
        iLibruaryDAO.save(newObject);
    }

    @Override
    public void update(Book updateObject, int id) {
        iLibruaryDAO.update(updateObject, id);
    }

    @Override
    public void delete(int id) {
        iLibruaryDAO.delete(id);
    }

    @Override
    public Book showInfo(int id) {
        return  iLibruaryDAO.showInfo(id);
    }

    @Override
    public List<Book> index() {
        return iLibruaryDAO.index();
    }
}
