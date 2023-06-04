package ru.alex.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alex.spring.DAO.LibruaryDAO;

@Controller
public class MyController {
    private final LibruaryDAO libruaryDAO;

    public MyController(LibruaryDAO libruaryDAO) {
        this.libruaryDAO = libruaryDAO;
    }

    @GetMapping
 public String index(Model model){
        model.addAttribute("people", libruaryDAO.indexPersons());
        return "people/index";
    }

}
