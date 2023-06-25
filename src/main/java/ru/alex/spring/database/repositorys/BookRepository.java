package ru.alex.spring.database.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.spring.database.model.Book;
import ru.alex.spring.database.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    public List<Book> findByTitleStartingWith(String title);

    Optional<Book> findByTitle(String title);
}
