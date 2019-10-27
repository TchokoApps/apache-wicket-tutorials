package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel;

import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util.WicketComponentUtils;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormType;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class AbstractDefaultContentPanel extends Panel {

    private static final long serialVersionUID = 1L;

    private static final String LEFT_FORM_ID = "leftForm";

    private static final String RIGHT_FORM_ID = "rightForm";

    public final static String PANEL_ID = "contentPanel";

    protected WicketComponentUtils getComponentUtils() {
        return WicketComponentUtils.getInstance();
    }

    public AbstractDefaultContentPanel() {
        super(PANEL_ID);
        addLefForm();
        addRightForm();
    }

    private void addLefForm() {
        final BootstrapForm<Object> form = getComponentUtils().buildBootstrapForm(LEFT_FORM_ID, null, FormType.Default);
        add(form);
    }

    private void addRightForm() {
        final BootstrapForm<Object> form = getComponentUtils().buildBootstrapForm(RIGHT_FORM_ID, null, FormType.Default);
        add(form);
    }

    @SuppressWarnings("unchecked")
    protected BootstrapForm<Object> getLeftForm() {
        return (BootstrapForm<Object>) get(LEFT_FORM_ID);
    }

    @SuppressWarnings("unchecked")
    protected BootstrapForm<Object> getRightForm() {
        return (BootstrapForm<Object>) get(RIGHT_FORM_ID);
    }
}
