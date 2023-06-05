package ru.alex.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alex.spring.database.DAO.LibruaryDAO;

@Controller()
@RequestMapping("book")
public class BookController {
    private final LibruaryDAO libruaryDAO;

    public BookController(LibruaryDAO libruaryDAO) {
        this.libruaryDAO = libruaryDAO;
    }
    @GetMapping("/books")
    public String indexBook(Model model) {
        model.addAttribute("books", libruaryDAO.indexBooks());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String showInfoAboutBook(@PathVariable int id, Model model) {
        model.addAttribute("dataAboutBook",libruaryDAO.showBookInfo(id));
        return "book/show";
    }
}
