package ru.alex.spring.database.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.spring.database.model.Book;
import ru.alex.spring.database.model.Person;
import ru.alex.spring.database.repositorys.BookRepository;
import ru.alex.spring.database.repositorys.PersonRepository;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private final PersonRepository personRepository;
    public BookService(BookRepository bookRepository, PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
    }
    @Transactional
    public void save(Book book){
        bookRepository.save(book);
    }
    @Transactional
    public void delete(Integer id){
        bookRepository.deleteById(id);
    }

    public List<Book> index(){
        return bookRepository.findAll();
    }

    public Book find(Integer id){
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Integer id, Book book){
        book.setId(id);
        bookRepository.save(book);
    }


    @Transactional
    public void updateOwner(Integer id, Person person, Book book){
        book = bookRepository.findById(id).orElse(null);
        book.setPerson(personRepository.findById(person.getId()).orElse(null));
        bookRepository.save(book);
    }
    @Transactional
    public void updateOnNull(Integer id, Book book){
        book = bookRepository.findById(id).orElse(null);
        book.setPerson(null);
        bookRepository.save(book);
    }

}