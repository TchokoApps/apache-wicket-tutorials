package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;

public interface SaveAction extends Serializable {

    void onSaveAction(final AjaxRequestTarget target, final Form<?> form);
}
