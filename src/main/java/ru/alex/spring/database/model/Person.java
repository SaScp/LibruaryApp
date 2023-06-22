package ru.alex.spring.database.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name")
    @NotEmpty(message = "Пожалуйста впешите имя!")
    private String fullName;
    @Column(name = "year_of_birth")
    private Integer yearOfBirth;
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Book> books;


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

    public String getFull_name() {
        return fullName;
    }

    public void setFull_name(String name) {
        this.fullName = name;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer year_born) {
        this.yearOfBirth = year_born;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", books=" + books +
                '}';
    }
}
