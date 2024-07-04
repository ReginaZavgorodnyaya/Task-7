package ru.itmentor.spring.boot_security.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmentor.spring.boot_security.demo.service.UserService;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;

    @GetMapping("/allusers")
    public String allUsers(ModelMap modelMap){
        modelMap.addAttribute("users", userService.findAll());
        return "allUsers";
    }

    @GetMapping("/save-user")
    public String save(){
        return "/add-user";
    }

    @GetMapping("/delete-user")
    public String deleteUserById() {
        return "delete-user";
    }

    @GetMapping("/update-user")
    public String update(){
        return "update-user";
    }
}
