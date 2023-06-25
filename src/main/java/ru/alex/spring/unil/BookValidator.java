package ru.alex.spring.unil;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.alex.spring.database.model.Book;
import ru.alex.spring.database.service.BookService;
@Component
public class BookValidator implements Validator {
    private final BookService bookService;

    public BookValidator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;

        if(bookService.findByTitleBook(book.getTitle()).isPresent()){
            errors.rejectValue("title","", "Такая книга уже есть");
        }

    }
}
