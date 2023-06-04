package ru.alex.spring.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class Person {
    private int id;
    private String name;
    private int year_born;

    private List<Book> books = new ArrayList<>();
    public Person(String name, int year_born, int id) {
        this.name = name;
        this.year_born = year_born;
        this.id = id;
    }
    public Person(){}

    public int getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_born() {
        return year_born;
    }

    public void setYear_born(int year_born) {
        this.year_born = year_born;
    }
}
