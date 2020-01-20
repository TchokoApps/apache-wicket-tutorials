package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;

public interface NewAction extends Serializable {

    void onNewAction(final AjaxRequestTarget target, final Form<?> form);
}