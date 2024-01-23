package com.example.Library.Management.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && "admin".equals(password)) {
            model.addAttribute("username", username);
            return "homepage";
        }
        else if ("user".equals(username) && "user".equals(password)) {
            model.addAttribute("username", username);
            return "homepageUser";
        }
        else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
