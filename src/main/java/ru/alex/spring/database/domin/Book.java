package ru.alex.spring.database.domin;

public class Book {
    private int id;
    private int user_id;
    private String name;
    private String autor;
    private int year_relese;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
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

    public int getYear_relese() {
        return year_relese;
    }

    public void setYear_relese(int year_relese) {
        this.year_relese = year_relese;
    }
}
