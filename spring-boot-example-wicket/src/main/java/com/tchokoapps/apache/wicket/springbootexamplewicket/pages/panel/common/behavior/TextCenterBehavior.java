package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.common.behavior;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;

import java.io.Serializable;

public class TextCenterBehavior extends AttributeAppender {

    public TextCenterBehavior() {
        super("class", "text-center", " ");
    }

    public TextCenterBehavior(String attribute, IModel<?> replaceModel) {
        super(attribute, replaceModel);
    }

    public TextCenterBehavior(String attribute, Serializable value) {
        super(attribute, value);
    }

    public TextCenterBehavior(String attribute, Serializable value, String separator) {
        super(attribute, value, separator);
    }

    public TextCenterBehavior(String attribute, IModel<?> appendModel, String separator) {
        super(attribute, appendModel, separator);
    }
}
