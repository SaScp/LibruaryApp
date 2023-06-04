package ru.alex.spring.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alex.spring.models.Book;
import ru.alex.spring.models.Person;

import java.util.List;

@Component
public class LibruaryDaoInit implements LibruaryDAO{
    private final JdbcTemplate jdbcTemplate;

    public LibruaryDaoInit(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void personSave(Person person) {
        jdbcTemplate.update("insert into person(name, year_born) values (?, ?)",
                person.getName(),person.getYear_born());
    }

    public void bookSave(Book book) {
        jdbcTemplate.update("insert into book(name, autor, year_relese) values (?,?,?)",
                book.getName(),
                book.getAutor(),
                book.getYear_relese());

    }

    public void updateBook(Book updateBook, int id) {
        jdbcTemplate.update("update book set name=?, autor=?,year_relese=? where book_id=id",
                updateBook.getName(),
                updateBook.getAutor(),
                updateBook.getYear_relese());
    }

    public void updatePerson(Person updatePerson, int id) {
        jdbcTemplate.update("update person set name=?, year_born=? where user_id = id",
                updatePerson.getName(),
                updatePerson.getYear_born());
    }

    public void deletePerson(Person person) {

    }

    public void deleteBook(Book book) {

    }

    public Person showPersonInfo(int id) {
        return jdbcTemplate.query("select * from Person",
                new BeanPropertyRowMapper<>(Person.class))
                .stream().filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    public Book showBookInfo(int id) {
        return jdbcTemplate.query("select * from book",
                        new BeanPropertyRowMapper<>(Book.class))
                .stream().filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);
    }

    public List<Person> indexPersons() {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Book> indexBooks() {
        return jdbcTemplate.query("select * from book",
                new BeanPropertyRowMapper<>(Book.class));
    }
}
