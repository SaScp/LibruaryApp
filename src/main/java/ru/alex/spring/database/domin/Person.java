package ru.alex.spring.database.domin;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


public class Person {
    private Integer id;
    @NotEmpty(message = "Пожалуйста впешите имя!")
    private String name;
    private Integer year_born;

    private List<Book> books = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear_born() {
        return year_born;
    }

    public void setYear_born(Integer year_born) {
        this.year_born = year_born;
    }
}
