package ru.alex.spring.database.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column //(name = "name")
    @NotNull(message = "это поле не должно быть пустым!")
    @NotEmpty(message = "это поле не должно быть пустым!")
    private String title;
    @Column (name = "autor")
    @NotNull(message = "кинга без автора?! Шутишь?")
    @NotEmpty(message = "кинга без автора?! Шутишь?")
    private String author;
    @Column //(name = "year_relese")
    private Integer year;
    @Column(name = "date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getAutor() {
        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year_relese) {
        this.year = year_relese;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date date) {
        this.returnDate = date;
    }

}
