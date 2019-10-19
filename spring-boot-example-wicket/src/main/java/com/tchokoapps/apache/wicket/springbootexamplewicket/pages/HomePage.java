package com.tchokoapps.apache.wicket.springbootexamplewicket.pages;

import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util.WicketComponentUtils;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    private static final String FEEDBACK_PANEL_ID = "feedbackaPanel";

    private final WicketComponentUtils componentUtils = WicketComponentUtils.getInstance();

    public HomePage(final PageParameters parameters) {
        super(parameters);
        final StringValue theme = parameters.get("theme");
    }
}
