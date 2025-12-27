package org.example.spring_web_scopes.session_scoped;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

   // @Autowired
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam String username, @RequestParam String password, Model model) {

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean login = loginProcessor.isValid();

        if(login){
            return "redirect:/main";
        }

        model.addAttribute("message", "Login failed!");
        return "login";
    }
}
