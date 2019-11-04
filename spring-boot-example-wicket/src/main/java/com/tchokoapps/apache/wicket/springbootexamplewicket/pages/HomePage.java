package com.tchokoapps.apache.wicket.springbootexamplewicket.pages;

import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.AbstractDefaultContentPanel;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.patients.PatientContentPanel;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util.WicketComponentUtils;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.ButtonList;
import de.agilecoders.wicket.core.markup.html.bootstrap.common.NotificationPanel;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.ImmutableNavbarComponent;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarAjaxLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarDropDownButton;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import org.apache.wicket.Component;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.util.string.StringValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    private static final String FEEDBACK_PANEL_ID = "feedbackPanel";
    private final static ResourceReference LOGO = new PackageResourceReference(HomePage.class,"logo.png");
    public static final String TITLE = "Wicket Bootstrap Sample";

    private final WicketComponentUtils componentUtils = WicketComponentUtils.getInstance();

    public HomePage(final PageParameters parameters) {
        super(parameters);
        final StringValue theme = parameters.get("theme");
        handleTheme(theme);
        addNavBar(theme);
        addOrReplaceContentPanel(new PatientContentPanel());
    }

    private void addNavBar(StringValue theme) {

        Navbar navbar = new Navbar("navbar");
        navbar.fluid();
        navbar.setPosition(Navbar.Position.TOP);
        navbar.setBrandName(Model.of(TITLE));

        navbar.addComponents(new ImmutableNavbarComponent(new NavbarDropDownButton(Model.of("Basic Data")) {

            @Override
            protected List<AbstractLink> newSubMenuButtons(final String buttonMarkupId) {
                final List<AbstractLink> subMenu = new ArrayList<AbstractLink>();
                subMenu.add(new NavbarAjaxLink<String>(ButtonList.getButtonMarkupId(), Model.of("Patient")) {
                    @Override
                    public void onClick(final AjaxRequestTarget target) {
                        addOrReplaceContentPanel(new PatientContentPanel(), target);
                    }
                });
                return subMenu;
            }
        }));
        this.add(navbar);
    }

    public void cleanFeedbackPanel(final AjaxRequestTarget target) {
        Session.get().getFeedbackMessages().clear();
        if (Objects.nonNull(target)) {
            target.add(getFeedbackPanel());
        }
    }

    public NotificationPanel getFeedbackPanel() {
        return (NotificationPanel) get(FEEDBACK_PANEL_ID);
    }

    private void handleTheme(final StringValue theme) {
        final IBootstrapSettings settings = Bootstrap.getSettings(getApplication());
        if (theme.isEmpty()) {
            settings.getActiveThemeProvider().setActiveTheme(settings.getThemeProvider().defaultTheme());
        } else {
            if (settings.getThemeProvider().available().stream().map(t -> t.name()).anyMatch(tn -> theme.toString("").equals(tn))) {
                settings.getActiveThemeProvider().setActiveTheme(theme.toString(""));
            }
        }
    }

    void addOrReplaceContentPanel(final AbstractDefaultContentPanel contentPanel) {
        addOrReplaceContentPanel(contentPanel, null);
    }

    void addOrReplaceContentPanel(final AbstractDefaultContentPanel contentPanel, final AjaxRequestTarget target) {
        addOrReplace(contentPanel);
        handlerInjectComponents();
        if (Objects.nonNull(target)) {
            target.add(contentPanel);
        }
    }

    private void handlerInjectComponents() {
        visitChildren(Component.class, (object, visit) -> {
            Injector.get().inject(object);
        });
    }
}
