package com.tchokoapps.apache.wicket.springbootwicketpro.pages;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

@Slf4j
@Getter
@Setter
public class Login extends AppBasePage {
    public static final String WICKET = "wicket";
    private String userId;
    private String password;

    public Login() {
        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        TextField userIdTextField = new TextField("userId", new PropertyModel(this, "userId"));
        PasswordTextField passwordTextField = new PasswordTextField("password", new PropertyModel(this, "password"));
        passwordTextField.setResetPassword(false);
        LoginForm loginForm = new LoginForm("form");
        loginForm.add(userIdTextField);
        loginForm.add(passwordTextField);
        add(feedbackPanel);
        add(loginForm);
    }

    public boolean authenticate(final String userId, final String password) {
        if (WICKET.equalsIgnoreCase(userId) && WICKET.equalsIgnoreCase(password))
            return true;
        else return false;
    }

    class LoginForm extends Form<Void> {

        public LoginForm(String id) {
            super(id);
        }

        @Override
        protected void onSubmit() {
            log.info("You entered userId={} and password={}", userId, password);
            if (authenticate(getUserId(), getPassword())) {
                Welcome welcomePage = new Welcome();
                welcomePage.setUserId(getUserId());
                setResponsePage(welcomePage);
                log.info("User authenticate successfully");
            } else {
                log.info("Authentification failed. Please try again");
                String errMsg = getLocalizer().getString("login.errors.invalidCredentials", Login.this, "Unable to sign you in");
                error(errMsg);
            }
        }
    }
}