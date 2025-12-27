package org.example.spring_web_scopes.application_scoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    @Autowired
    private LoggedUserManagementService loggedUserManagementService;

    @Autowired
    private LoginCountService loginCountService;
    private String username;
    private String password;

    public boolean isValid() {
        loginCountService.increment();
        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;
        if(username.equals("john") && password.equals("12345")) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }
        return loginResult;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
