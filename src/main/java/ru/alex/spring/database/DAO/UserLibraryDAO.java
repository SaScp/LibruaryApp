package ru.alex.spring.database.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.alex.spring.database.domin.Book;
import ru.alex.spring.database.domin.Person;

import java.util.List;
@Repository
public class UserLibraryDAO implements ILibruaryDAO<Person> {
    private final JdbcTemplate jdbcTemplate;

    public UserLibraryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void save(Person newObject) {
        jdbcTemplate.update("insert into person(name, year_born) values (?, ?)",
                newObject.getName(), newObject.getYear_born());
    }

    @Override
    public void update(Person updateObject, int id) {
        jdbcTemplate.update("update person set name=?, year_born=? where user_id = id",
                updateObject.getName(),
                updateObject.getYear_born());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from person where id=?", id);
    }

    @Override
    public Person showInfo(int id) {
        Person person = jdbcTemplate.query("select * from Person",
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
        person.setBooks(ShowBookUsers(id));
        return person;
    }
    public List<Book> ShowBookUsers(int user_id){
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class))
                .stream().
                filter(book -> book.getUser_id() == user_id)
                .toList();
    }
    @Override
    public List<Person> index() {
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));
    }
}
