package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

public interface DetailAction<T> extends Serializable {

    void onDetailAction(final AjaxRequestTarget target, final IModel<T> model);
}