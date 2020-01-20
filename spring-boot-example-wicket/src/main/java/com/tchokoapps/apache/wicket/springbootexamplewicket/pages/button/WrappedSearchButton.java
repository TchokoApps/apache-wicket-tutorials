package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.button;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.GlyphIconType;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class WrappedSearchButton<T> extends Panel {

    private final static String DETAIL_BUTTON_ID = "detailButton";

    public WrappedSearchButton(String id, IModel<?> model) {
        super(id, model);
        this.add(new BootstrapAjaxButton(DETAIL_BUTTON_ID, Buttons.Type.Default) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target,form);
            }
        }.setIconType(GlyphIconType.alignjustify));
    }

    public BootstrapAjaxButton getDetailButton() {
        return (BootstrapAjaxButton) get(DETAIL_BUTTON_ID);
    }
}
