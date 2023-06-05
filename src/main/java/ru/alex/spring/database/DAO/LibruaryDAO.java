package ru.alex.spring.database.DAO;

import ru.alex.spring.models.Book;
import ru.alex.spring.models.Person;

import java.util.List;

public interface LibruaryDAO {
    public void personSave(Person person);
    public void bookSave(Book book);
    public void updateBook(Book updateBook, int id);
    public void updatePerson(Person updateBook,int id);
    public void deletePerson(Person person);
    public void  deleteBook(Book book);
    public Person showPersonInfo(int id);
    public Book showBookInfo(int id);
    public List<Person> indexPersons();
    public List<Book> indexBooks();
 }
