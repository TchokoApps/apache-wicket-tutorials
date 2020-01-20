package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action;

import org.apache.wicket.ajax.AjaxRequestTarget;

public interface AjaxAction {

    void onAjaxAction(final AjaxRequestTarget target);
}
