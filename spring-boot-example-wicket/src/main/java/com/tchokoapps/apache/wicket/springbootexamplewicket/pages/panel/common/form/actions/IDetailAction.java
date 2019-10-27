package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.common.form.actions;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

public interface IDetailAction<T> {
    void onDetailAction(final AjaxRequestTarget target, final IModel<T> model);
}
