package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;

public interface CancelAction {
    
    void onCancelAction(final AjaxRequestTarget target, final Form<?> form);
}
