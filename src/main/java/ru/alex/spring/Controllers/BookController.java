package ru.alex.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alex.spring.database.service.IService;
import ru.alex.spring.database.domin.Book;

@Controller
@RequestMapping("book")
public class BookController {
    private final IService<Book> bookIService;

    public BookController(IService<Book> bookIService) {
        this.bookIService = bookIService;
    }
    @GetMapping("/books")
    public String indexBook(Model model) {
        model.addAttribute("books", bookIService.index());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String showInfoAboutBook(@PathVariable int id, Model model) {
        model.addAttribute("dataAboutBook",bookIService.showInfo(id));
        return "book/show";
    }
}
