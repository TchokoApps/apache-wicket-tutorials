package com.tchokoapps.apache.wicket.springbootwicketpro.pages.extensions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

@Slf4j
@Getter
@Setter
public class Login extends AppBasePage {
    public static final String WICKET = "wicket";
    private String userId;
    private String password;

    public Login() {
        TextField userIdTextField = new TextField("userId", new PropertyModel(this, "userId"));
        PasswordTextField passwordTextField = new PasswordTextField("password", new PropertyModel(this, "password"));
        passwordTextField.setResetPassword(false);

        Form form = new Form("loginForm") {
            @Override
            protected void onSubmit() {
                log.info("You entered userId={} and password={}", userId, password);
                if (authenticate(getUserId(), getPassword())) {
                    log.info("User authenticate successfully");
                } else {
                    log.info("Authentification failed. Please try again");
                }
            }
        };

        form.add(userIdTextField);
        form.add(passwordTextField);
        this.add(form);
    }

    public boolean authenticate(final String userId, final String password) {
        if (WICKET.equalsIgnoreCase(userId) && WICKET.equalsIgnoreCase(password))
            return true;
        else return false;
    }
}
