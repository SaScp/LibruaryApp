package ru.alex.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alex.spring.database.service.IService;
import ru.alex.spring.database.domin.Person;

@Controller
@RequestMapping("user")
public class UserController {
  private final IService<Person> personIService;

    public UserController(IService<Person> personIService) {
        this.personIService = personIService;
    }

    @GetMapping("/none") //PODO закончю позже
    public String startPage(){
        return "StartPage";
    }
    @GetMapping("/users")
    public String indexUser(Model model) {
        model.addAttribute("people",personIService.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String ShowInfoAboutUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("dataAboutUser",personIService.showInfo(id));
         return "people/show";
    }

    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("dataAboutUser") Person person) {
        return "people/addUser";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("dataAboutUser") Person person) {
        personIService.save(person);
        return "redirect:/users";
    }
}
