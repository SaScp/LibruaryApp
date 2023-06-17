package ru.alex.spring.database.service;

import org.springframework.stereotype.Service;
import ru.alex.spring.database.DAO.BookLibraryDAO;
import ru.alex.spring.database.model.Book;

import java.util.List;
@Service
public class BookService{
    private final BookLibraryDAO iLibruaryDAO;

    public BookService(BookLibraryDAO LibruaryDAO) {
        this.iLibruaryDAO = LibruaryDAO;
    }

    public void save(Book newObject) {
        iLibruaryDAO.save(newObject);
    }

    public void update(Object data, Integer id, String actions) {
        iLibruaryDAO.update(data, id, actions);
    }

    public void delete(Integer id) {
        iLibruaryDAO.delete(id);
    }


    public Book showInfo(Integer id) {
        return  iLibruaryDAO.showInfo(id);
    }

    public List<Book> index() {
        return iLibruaryDAO.index();
    }
}
