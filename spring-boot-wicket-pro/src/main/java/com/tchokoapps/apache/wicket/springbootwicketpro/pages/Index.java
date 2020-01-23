package com.tchokoapps.apache.wicket.springbootwicketpro.pages;

import com.tchokoapps.apache.wicket.springbootwicketpro.pages.extensions.Login;
import com.tchokoapps.apache.wicket.springbootwicketpro.pages.extensions.UserProfilePage;
import com.tchokoapps.apache.wicket.springbootwicketpro.pages.extensions.Welcome;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class Index extends WebPage {

    public Index() {
        Link loginLink = new Link("loginLink") {
            @Override
            public void onClick() {
                setResponsePage(Login.class);
            }
        };

        Link userProfilePageLink = new Link("userProfilePageLink") {
            @Override
            public void onClick() {
                setResponsePage(UserProfilePage.class);
            }
        };

        Link welcomeLink = new Link("welcomeLink") {
            @Override
            public void onClick() {
                setResponsePage(Welcome.class);
            }
        };

        add(loginLink);
        add(userProfilePageLink);
        add(welcomeLink);
    }
}
