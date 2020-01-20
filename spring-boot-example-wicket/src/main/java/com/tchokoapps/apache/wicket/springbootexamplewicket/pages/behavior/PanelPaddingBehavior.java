package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.behavior;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;

import java.io.Serializable;

public class PanelPaddingBehavior extends AttributeModifier {

    private static final String ATTRIBUTE = "style";
    private static final String VALUE = "padding: 15px;";

    public PanelPaddingBehavior(String attribute, IModel<?> replaceModel) {
        super(attribute, replaceModel);
    }

    public PanelPaddingBehavior(String attribute, Serializable value) {
        super(attribute, value);
    }

    public PanelPaddingBehavior() {
        super(ATTRIBUTE, VALUE);
    }


    public static class TextCenterBehavior extends AttributeAppender {

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
}
