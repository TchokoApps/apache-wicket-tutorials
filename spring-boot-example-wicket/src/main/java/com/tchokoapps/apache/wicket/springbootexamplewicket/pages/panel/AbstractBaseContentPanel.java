package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel;

import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util.WicketComponentUtils;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class AbstractBaseContentPanel extends Panel {

    public final static String PANEL_ID = "contentPanel";

    public AbstractBaseContentPanel() {
        super(PANEL_ID);
        getComponentUtils().prepareComponent(this);
    }

    public AbstractBaseContentPanel(String id) {
        super(id);
    }

    public AbstractBaseContentPanel(String id, IModel<?> model) {
        super(id, model);
    }

    private WicketComponentUtils getComponentUtils() {
        return WicketComponentUtils.getInstance();
    }
}
