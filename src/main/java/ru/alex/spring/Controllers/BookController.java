package ru.alex.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alex.spring.database.domin.Person;
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
    @GetMapping("/addBook")
    public String addUser(Model model) {
        model.addAttribute("dataAboutBook", new Book());
        return "book/addBook";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dataAboutBook") Book book) {
        bookIService.save(book);
        return "redirect:/user/users";
    }
    @GetMapping("/{id}/editUser")
    public String editUser(Model model, @PathVariable("id") int id){
        model.addAttribute("dataAboutBook", bookIService.showInfo(id));
        return "book/edit";
    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("dataAboutBook") Book book, @PathVariable("id") int id){
        bookIService.update(book, id);
        return "redirect:/user/users";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("dataAboutBook") Book book,@PathVariable("id") int id){
        bookIService.delete(id);
        return "redirect:/user/users";
    }
}
