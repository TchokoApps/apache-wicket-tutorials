package com.tchokoapps.apache.wicket.springbootwicketpro.pages;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

@Slf4j
@Data
public class Welcome extends WebPage {
    private String userId;

    public Welcome() {
        Label messageLabel = new Label("message", new PropertyModel<>(this, "userId"));
        this.add(messageLabel);

        Link userProfileLink = new Link("linkToUserProfile") {

            @Override
            public void onClick() {
                setResponsePage(UserProfilePage.class);
            }
        };

        Link loginLink = new Link("linkToLogin") {

            @Override
            public void onClick() {
                setResponsePage(Login.class);
            }
        };

        this.add(userProfileLink);
        this.add(loginLink);
    }
}
