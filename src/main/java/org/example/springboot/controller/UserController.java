package org.example.springboot.controller;

import org.example.springboot.model.User;
import org.example.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "show";
    }

    @GetMapping("/users/adding")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute(value = "user") User user) {
        userService.saveUser(user);

        return "redirect:/users";
    }

    @GetMapping("/users/updateuser")
    public String updateUser(@RequestParam(value = "id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("userupdate", user);
        return "updateuser";
    }

    @PostMapping("/users/updateuser")
    public String updateUser(@ModelAttribute(value = "userupdate") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/deleteuser")
    public String deleteUser(@RequestParam(value = "id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("deleteuser", user);
        return "deleteuser";
    }

    @PostMapping("/users/deleteuser")
    public String deleteUser(@ModelAttribute(value = "deleteuser") User user) {
        userService.deleteUser(user);
        return "redirect:/users";
    }
}
