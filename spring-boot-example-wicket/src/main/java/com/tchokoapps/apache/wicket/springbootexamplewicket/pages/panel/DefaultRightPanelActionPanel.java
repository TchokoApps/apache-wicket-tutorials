package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel;

import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action.CancelAction;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action.DeleteAction;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action.SaveAction;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util.WicketComponentUtils;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class DefaultRightPanelActionPanel extends Panel {

    protected static final String SAVE_BUTTON_ID = "saveButton";
    protected static final String DELETE_BUTTON_ID = "deleteButton";
    protected static final String CANCEL_BUTTON_ID = "cancelButton";

    private final WicketComponentUtils componentUtils = WicketComponentUtils.getInstance();

    public DefaultRightPanelActionPanel(final String id, final SaveAction saveAction, final DeleteAction deleteAction, final CancelAction cancelAction) {
        super(id, Model.of("footer"));

        add(componentUtils.prepareComponent(new BootstrapAjaxButton(SAVE_BUTTON_ID, Model.of("Save"), Buttons.Type.Primary) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                saveAction.onSaveAction(target, form);
            }
        }));

        add(componentUtils.prepareComponent(new BootstrapAjaxButton(DELETE_BUTTON_ID, Model.of("Delete"), Buttons.Type.Danger) {
            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
                deleteAction.onDeleteAction(target, form);
            }
        }.setDefaultFormProcessing(false)));

        add(componentUtils.prepareComponent(new BootstrapAjaxButton(CANCEL_BUTTON_ID, Model.of("Cancel"), Buttons.Type.Default) {
            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
                cancelAction.onCancelAction(target, form);
            }
        }.setDefaultFormProcessing(false)));
    }
}
