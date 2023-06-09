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
    private final IService<Person> userIService;
    public BookController(IService<Book> bookIService, IService<Person> userIService) {
        this.bookIService = bookIService;
        this.userIService = userIService;
    }
    @GetMapping("/books")
    public String indexBook(Model model) {
        model.addAttribute("books", bookIService.index());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String showInfoAboutBook(@PathVariable int id,
                                    Model model,
                                    Model userModel,
                                    @ModelAttribute("person") Person person) {
        model.addAttribute("dataAboutBook",bookIService.showInfo(id));
        userModel.addAttribute("people", userIService.index());
        return "book/show";
    }

    @PatchMapping("/updateId/{id}")
    public String updateAction(@PathVariable("id") Integer id,
                               @ModelAttribute("person") Person person){
        bookIService.update(person, id, "updateId");
        return "redirect:/book/{id}";
    }
    @PatchMapping("/updateNull/{id}")
    public String updateNullAction(@PathVariable("id") Integer id,
                                   @ModelAttribute("person") Person person) {
        bookIService.update(person, id, "updateNull");
        return "redirect:/book/{id}";
    }
    @GetMapping("/addBook")
    public String addUser(Model model) {
        model.addAttribute("dataAboutBook", new Book());
        return "book/addBook";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dataAboutBook") Book book) {
        bookIService.save(book);
        return "redirect:/book/books";
    }
    @GetMapping("/{id}/editUser")
    public String editUser(Model model,
                           @PathVariable("id") int id) {
        model.addAttribute("dataAboutBook", bookIService.showInfo(id));
        return "book/edit";
    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("dataAboutBook") Book book,
                       @PathVariable("id") int id) {
        bookIService.update(book, id, "update");
        return "redirect:/book/books";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("dataAboutBook") Book book,
                             @PathVariable("id") int id) {
        bookIService.delete(id);
        return "redirect:/book/books";
    }
}
