package org.example.spring_web_scopes.request_scoped;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    public boolean isValid() {
        String username = this.getUsername();
        String password = this.getPassword();

        if(username.equals("john") && password.equals("12345")) {
            return true;
        } else {
            return false;
        }
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
