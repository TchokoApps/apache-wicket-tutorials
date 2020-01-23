package com.tchokoapps.apache.wicket.springbootwicketpro.pages.extensions;

import com.tchokoapps.apache.wicket.springbootwicketpro.common.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

import java.util.Arrays;

@Slf4j
public class UserProfilePage extends AppBasePage {

    public UserProfilePage() {
        UserProfile userProfile = new UserProfile();
        CompoundPropertyModel<UserProfile> userProfileCompoundPropertyModel = new CompoundPropertyModel<>(userProfile);

        UserProfileForm userProfileForm = new UserProfileForm("userProfile", userProfileCompoundPropertyModel);
        this.add(userProfileForm);

        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        add(feedbackPanel);

        TextField nameTextField = new TextField("name");
        TextField addressTextField = new TextField("address");
        TextField cityTextField = new TextField("city");
        TextField zipCodeTextField = new TextField("zipCode");
        TextField stateTextField = new TextField("state");
        DropDownChoice countryDropDownChoice = new DropDownChoice("country", Arrays.asList(new String[]{"Cameroon", "USA", "UK", "Germany", "France"}));
        TextField pinTextField = new TextField("pin");

        userProfileForm.add(nameTextField);
        userProfileForm.add(addressTextField);
        userProfileForm.add(cityTextField);
        userProfileForm.add(zipCodeTextField);
        userProfileForm.add(stateTextField);
        userProfileForm.add(countryDropDownChoice);
        userProfileForm.add(pinTextField);

    }

    class UserProfileForm extends Form {

        public UserProfileForm(String id, IModel model) {
            super(id, model);
        }

        @Override
        protected void onSubmit() {
            log.info("getModelObject()={}", this.getModelObject());
            info(getDefaultModelObjectAsString());
            UserProfile modelObject = (UserProfile) getModelObject();
            int pin = modelObject.getPin();
            String name = modelObject.getName();
            if (name == null) {
                error("User Name is a required field");
            }

            int minPinValue = 0;
            int maxPinValue = 5000;

            if (pin < minPinValue || pin > maxPinValue) {
                error(String.format("Please enter pin in the range %s - %s", Integer.toString(minPinValue), Integer.toString(maxPinValue)));
            }
        }
    }
}


