package ru.alex.spring.database.domin;

import javax.validation.constraints.NotNull;

public class Book {
    private Integer id;
    private Integer user_id;
    private String name;
    private String autor;
    private Integer year_relese;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getYear_relese() {
        return year_relese;
    }

    public void setYear_relese(Integer year_relese) {
        this.year_relese = year_relese;
    }
}
