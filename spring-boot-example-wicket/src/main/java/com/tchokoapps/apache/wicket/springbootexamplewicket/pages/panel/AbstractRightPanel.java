package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel;

import de.agilecoders.wicket.core.markup.html.bootstrap.panel.BootstrapGenericPanel;
import de.agilecoders.wicket.core.markup.html.bootstrap.panel.PanelType;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public abstract class AbstractRightPanel<T> extends BootstrapGenericPanel<T> {

    public AbstractRightPanel(String id, IModel<T> model, IModel<String> panelTitleModel, PanelType panelType) {
        super(id, model, panelTitleModel, panelType);
    }

    @Override
    protected Panel newBodyPanel(final String id, final IModel<T> model) {
        return newRightPanelContent(id, model);
    }

    @Override
    protected Panel newFooterPanel(final String id, final IModel<T> model) {
        return newRightPanelActionPanel(id, model);
    }

    public abstract DefaultRightPanelActionPanel newRightPanelActionPanel(final String id, final IModel<T> model);

    public abstract AbstractRightPanelContent<T> newRightPanelContent(final String id, final IModel<T> model);
}
