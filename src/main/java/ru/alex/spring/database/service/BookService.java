package ru.alex.spring.database.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.spring.database.model.Book;
import ru.alex.spring.database.model.Person;
import ru.alex.spring.database.repositorys.BookRepository;
import ru.alex.spring.database.repositorys.PersonRepository;

import java.util.*;

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

    public List<Book> index(int page, int books_per_page){
        return bookRepository.findAll(PageRequest.of(page, books_per_page)).getContent();
    }
    public List<Book> index(){
        return bookRepository.findAll();
    }

    public List<Book> indexWithSortedByYear(){
        return bookRepository.findAll(Sort.by("year"));
    }

    public List<Book> indexWithAll(int page, int books_per_page){
        return bookRepository.findAll(PageRequest.of(page, books_per_page, Sort.by("year"))).getContent();
    }
    public Book find(Integer id){
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Integer id, Book book){
        book.setId(id);
        bookRepository.save(book);
    }

    public List<Book> findBook(String title){

        return title.equals("")? null : bookRepository.findByTitleStartingWith(title);
    }

    @Transactional
    public void updateOwner(Integer id, Person person, Book book){
        book = bookRepository.findById(id).orElse(null);
        book.setPerson(personRepository.findById(person.getId()).orElse(null));
        Date date = new Date();
        book.setReturnDate(new Date(date.getYear(), date.getMonth(), date.getDate()));
        bookRepository.save(book);
    }

    @Transactional
    public void updateOnNull(Integer id, Book book){
        book = bookRepository.findById(id).orElse(null);
        book.setPerson(null);
        book.setReturnDate(null);
        bookRepository.save(book);
    }

    public Optional<Book> findByTitleBook(String title){
        return bookRepository.findByTitle(title);
    }
}
