package ru.alex.spring.database.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.alex.spring.database.domin.Book;
import ru.alex.spring.database.domin.Person;

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
    public void update(Object data, Integer id, String actions) {
        Person person = null;
        Book book = null;
        if(data instanceof Person)
            person = (Person) data;
        else
            book = (Book) data;

        switch (actions) {
            case "update"->jdbcTemplate.update("update book set " +
                            "name=?, " +
                            "autor=?, " +
                            "year_relese=? where book_id=?",
                    book.getName(),
                    book.getAutor(),
                    book.getYear_relese(),
                    id);
            case "updateId" -> {
                assert person != null;
                jdbcTemplate.update("update book set user_id=? where id=?",person.getId(), id);
            }
            case "updateNull" -> jdbcTemplate.update("update book set user_id=null where id=?", id);
        }
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
