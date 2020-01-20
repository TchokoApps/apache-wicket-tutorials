package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel;

import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util.WicketComponentUtils;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class AbstractBaseContentPanel extends Panel {

    protected static final WicketComponentUtils componentUtils = WicketComponentUtils.getInstance();

    private static final String PANEL_ID = "contentPanel";

    public AbstractBaseContentPanel() {
        super(PANEL_ID);
        componentUtils.prepareComponent(this);
    }

    public AbstractBaseContentPanel(IModel<?> model) {
        super(PANEL_ID, model);
        componentUtils.prepareComponent(this);
    }

    protected static WicketComponentUtils getComponentUtils() {
        return componentUtils;
    }
}
