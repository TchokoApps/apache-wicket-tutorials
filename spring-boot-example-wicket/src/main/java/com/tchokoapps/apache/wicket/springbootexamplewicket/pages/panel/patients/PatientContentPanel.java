package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.patients;

import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Address;
import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Patient;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.AbstractDefaultContentPanel;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.common.form.WrappedSearchButton;
import com.tchokoapps.apache.wicket.springbootexamplewicket.services.PatientService;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipConfig;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.GlyphIconType;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PatientContentPanel extends AbstractDefaultContentPanel {

    private static final long serialVersionUID = 1L;

    private static final String PATIENT_RIGHT_PANEL_ID = "patientRightPanel";

    private static final String PATIENT_DATA_TABLEL_ID = "patientDatatable";

    @Autowired
    private PatientService patientService;

    public PatientContentPanel() {
        super();
        addDataTable();
//        addOrReplacePatientFormPanel(new Patient(new Address()));
    }

    private void addOrReplacePatientFormPanel(final Patient patient) {
        addOrReplacePatientFormPanel(null, patient);
    }

    private void addOrReplacePatientFormPanel(final AjaxRequestTarget target, final Patient patient) {
        ComponentPropertyModel<Patient> model = new ComponentPropertyModel<>("patient");
    }

    private void addDataTable() {

        final List<IColumn<Patient, String>> columns = new ArrayList<>();
        columns.add(new PropertyColumn<Patient, String>(Model.of("Name"), "name"));
        columns.add(new PropertyColumn<Patient, String>(Model.of("CPF"), "cpf"));
        columns.add(new AbstractColumn<Patient, String>(Model.of("Active")) {
            @Override
            public void populateItem(final Item<ICellPopulator<Patient>> cellItem, final String componentId, final IModel<Patient> rowModel) {
                final Label activeLabel = new Label(componentId);
                final boolean active = rowModel.getObject().isActive();
                if (active) {
                    activeLabel.add(new AttributeAppender("class", GlyphIconType.ok.cssClassName()));
                }
                cellItem.add(activeLabel.add(new TooltipBehavior(Model.of(active ? "Active" : "Inactive"), new TooltipConfig().withAnimation(true))));
            }
        });

        columns.add(new AbstractColumn<Patient, String>(Model.of("Detail")) {
            @Override
            public void populateItem(final Item<ICellPopulator<Patient>> cellItem, final String componentId, final IModel<Patient> rowModel) {
                cellItem.add(new WrappedSearchButton<Patient>(componentId,rowModel));
            }
        });
    }
}