package ru.alex.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alex.spring.database.DAO.LibruaryDAO;

@Controller()
@RequestMapping("user")
public class UserController {
    private final LibruaryDAO libruaryDAO;

    public UserController(LibruaryDAO libruaryDAO) {
        this.libruaryDAO = libruaryDAO;
    }
    @GetMapping("/none") //PODO закончю позже
    public String startPage(){
        return "StartPage";
    }
    @GetMapping("/users")
    public String indexUser(Model model) {
        model.addAttribute("people", libruaryDAO.indexPersons());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String ShowInfoAboutUser(@PathVariable int id, Model model) {
        model.addAttribute("dataAboutUser",libruaryDAO.showPersonInfo(id));
         return "people/show";
    }

}
