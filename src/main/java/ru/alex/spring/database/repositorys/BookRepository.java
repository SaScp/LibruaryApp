package ru.alex.spring.database.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.spring.database.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
