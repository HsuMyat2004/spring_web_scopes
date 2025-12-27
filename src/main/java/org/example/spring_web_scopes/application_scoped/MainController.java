package org.example.spring_web_scopes.application_scoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private LoggedUserManagementService loggedUserManagementService;

    @Autowired
    private LoginCountService loginCountService;

    @GetMapping("/main")
    public String home(@RequestParam(required=false) String logout, Model model) {

        if(logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();

        if(username == null){
            return "redirect:/";
        }
        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);
        return "main";
    }

}
