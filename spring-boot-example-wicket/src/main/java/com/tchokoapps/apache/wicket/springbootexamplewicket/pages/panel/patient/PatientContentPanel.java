package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.patient;

import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Address;
import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Patient;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.action.*;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.behavior.PanelPaddingBehavior;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.button.WrappedSearchButton;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.AbstractDefaultContentPanel;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.AbstractRightPanel;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.AbstractRightPanelContent;
import com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.DefaultRightPanelActionPanel;
import com.tchokoapps.apache.wicket.springbootexamplewicket.services.PatientService;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipConfig;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.GlyphIconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.panel.PanelType;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.ComponentPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

public class PatientContentPanel extends AbstractDefaultContentPanel implements DetailAction<Patient>, NewAction, SaveAction, DeleteAction, CancelAction {

    private static final String PATIENT_RIGHT_PANEL_ID = "patientRightPanel";
    private static final String PATIENT_DATA_TABLE_ID = "patientDatatable";

    @SpringBean
    private PatientService patientService;

    public PatientContentPanel() {
        super();
        addDataTable();
        addOrReplacePatientFormPanel(new Patient(new Address()));
    }

    private void addOrReplacePatientFormPanel(final Patient patient) {
        addOrReplacePatientFormPanel(null, patient);
    }

    private void addOrReplacePatientFormPanel(final AjaxRequestTarget target, final Patient patient) {
        ComponentPropertyModel<Patient> model = new ComponentPropertyModel<>("patient");
        getRightForm().addOrReplace(getComponentUtils().prepareComponent(new AbstractRightPanel<Patient>(PATIENT_RIGHT_PANEL_ID, model, Model.of("Patient"), PanelType.Primary) {
            @Override
            public DefaultRightPanelActionPanel newRightPanelActionPanel(String id, IModel<Patient> model) {
                final DefaultRightPanelActionPanel actionPanel = new DefaultRightPanelActionPanel(id, PatientContentPanel.this, PatientContentPanel.this, PatientContentPanel.this);
                return actionPanel;
            }

            @Override
            public AbstractRightPanelContent<Patient> newRightPanelContent(String id, IModel<Patient> model) {
                return null;
            }
        }));
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
                cellItem.add(new PanelPaddingBehavior.TextCenterBehavior());
                cellItem.add(new WrappedSearchButton<Patient>(componentId, rowModel));
            }
        });

        final DataTable<Patient, String> table = new DataTable<>(PATIENT_DATA_TABLE_ID, columns, new PatientProvider(), 15);
        getComponentUtils().prepareDataTable(table);
        getLeftForm().add(table);
    }

    @Override
    public void onCancelAction(AjaxRequestTarget target, Form<?> form) {

    }

    @Override
    public void onDeleteAction(AjaxRequestTarget target, Form<?> form) {

    }

    @Override
    public void onDetailAction(AjaxRequestTarget target, IModel<Patient> model) {

    }

    @Override
    public void onNewAction(AjaxRequestTarget target, Form<?> form) {

    }

    @Override
    public void onSaveAction(AjaxRequestTarget target, Form<?> form) {

    }
}