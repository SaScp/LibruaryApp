package ru.alex.spring.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alex.spring.database.service.IService;
import ru.alex.spring.database.domin.Person;
import ru.alex.spring.unil.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
  private final IService<Person> personIService;
  private final PersonValidator personValidator;
    public UserController(IService<Person> personIService, PersonValidator personValidator) {
        this.personIService = personIService;
        this.personValidator = personValidator;
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
    public String addUser(Model model) {
        model.addAttribute("dataAboutUser", new Person());
        return "people/addUser";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dataAboutUser") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "people/addUser";
        personIService.save(person);
        return "redirect:/user/users";
    }
    @GetMapping("/{id}/editUser")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("dataAboutUser", personIService.showInfo(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("dataAboutUser") Person person, @PathVariable("id") int id) {
        personIService.update(person, id, "update");
        return "redirect:/user/users";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("dataAboutUser") Person person, @PathVariable("id") int id) {
        personIService.delete(id);
        return "redirect:/user/users";
    }
}
