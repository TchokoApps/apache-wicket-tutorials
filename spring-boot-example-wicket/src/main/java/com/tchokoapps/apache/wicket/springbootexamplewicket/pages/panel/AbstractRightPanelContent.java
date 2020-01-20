package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel;

import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.behavior.PanelPaddingBehavior;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util.WicketComponentUtils;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.behavior.AnimatedBehavior;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class AbstractRightPanelContent<T> extends Panel {

    private final WicketComponentUtils componentUtils = WicketComponentUtils.getInstance();

    public AbstractRightPanelContent(String id) {
        super(id);
    }

    public AbstractRightPanelContent(String id, IModel<?> model) {
        super(id, model);
        add(new PanelPaddingBehavior());
        add(new AnimatedBehavior(AnimatedBehavior.Animation.pulse));
    }


}
