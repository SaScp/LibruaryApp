package ru.alex.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alex.spring.database.model.Person;
import ru.alex.spring.database.model.Book;
import ru.alex.spring.database.service.BookService;
import ru.alex.spring.database.service.PersonService;

@Controller
@RequestMapping("book")
public class BookController {
    private final BookService bookService;
    private final PersonService userService;
    public BookController(BookService bookIService, PersonService userIService) {
        this.bookService = bookIService;
        this.userService = userIService;
    }
    @GetMapping("/books")
    public String indexBook(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "books_per_page",defaultValue = "0") Integer books_per_page,
                            @RequestParam(value = "sort_by_year", defaultValue = "false") Boolean sort_by_year,
                            Model model) {
        if(page != 0 && books_per_page!= 0)

            model.addAttribute("books", bookService.index(page, books_per_page));

        else if(sort_by_year.equals(true))

            model.addAttribute("books", bookService.indexWithSortedByYear());

        else if (page == 0 && books_per_page == 0 && sort_by_year.equals(true))

            model.addAttribute("books", bookService.indexWithAll(page, books_per_page));

        else

            model.addAttribute("books", bookService.index());

        return "book/index";
    }

    @GetMapping("/{id}")
    public String showInfoAboutBook(@PathVariable int id,
                                    Model model,
                                    Model userModel,
                                    @ModelAttribute("person") Person person) {
        model.addAttribute("dataAboutBook", bookService.find(id));
        userModel.addAttribute("people", userService.index());
        return "book/show";
    }

    @PatchMapping("/updateId/{id}")
    public String updateAction(@PathVariable("id") Integer id,
                               @ModelAttribute("person") Person person,
                               @ModelAttribute("dataAboutBook") Book book){
        bookService.updateOwner(id, person, book);
        //обновляем на другого пользователя
        return "redirect:/book/{id}";
    }
    @PatchMapping("/updateNull/{id}")
    public String updateNullAction(@PathVariable("id") Integer id, @ModelAttribute("dataAboutBook") Book book) {
        //обновляем на null
        bookService.updateOnNull(id, book);
        return "redirect:/book/{id}";
    }
    @GetMapping("/addBook")
    public String addUser(Model model) {
        model.addAttribute("dataAboutBook", new Book());
        return "book/addBook";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dataAboutBook") Book book) {
        bookService.save(book);
        return "redirect:/book/books";
    }
    @GetMapping("/{id}/editUser")
    public String editUser(Model model,
                           @PathVariable("id") int id) {
        model.addAttribute("dataAboutBook", bookService.find(id));
        return "book/edit";
    }
    @PatchMapping("/{id}")
    public String edit(@PathVariable("id") Integer id, @ModelAttribute("dataAboutBook") Book book) {
        bookService.update(id, book);
        return "redirect:/book/books";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("dataAboutBook") Book book,
                             @PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/book/books";
    }
}
