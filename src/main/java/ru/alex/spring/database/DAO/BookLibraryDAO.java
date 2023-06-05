package ru.alex.spring.database.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.alex.spring.database.domin.Book;

import java.util.List;
@Repository
public class BookLibraryDAO implements ILibruaryDAO<Book> {
    private final JdbcTemplate jdbcTemplate;

    public BookLibraryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void save(Book newObject) {
        jdbcTemplate.update("insert into book(name, autor, year_relese) values (?,?,?)",
                newObject.getName(),
                newObject.getAutor(),
                newObject.getYear_relese());
    }

    @Override
    public void update(Book updateObject, Integer id) {
        jdbcTemplate.update("update book set name=?, autor=?,year_relese=? where book_id=?",
                updateObject.getName(),
                updateObject.getAutor(),
                updateObject.getYear_relese(),
                id);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from book where id=?", id);
    }

    @Override
    public Book showInfo(Integer id) {
        return jdbcTemplate.query("select * from book",
                        new BeanPropertyRowMapper<>(Book.class))
                .stream().filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Book> index() {
        return jdbcTemplate.query("select * from book",
                new BeanPropertyRowMapper<>(Book.class));
    }
}
