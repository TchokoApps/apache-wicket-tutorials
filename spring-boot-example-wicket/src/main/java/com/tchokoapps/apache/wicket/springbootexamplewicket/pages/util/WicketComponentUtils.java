package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.util;

import java.io.Serializable;
import java.util.Objects;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.model.IModel;

import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormGroup;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormGroup.Size;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormType;
import de.agilecoders.wicket.core.markup.html.bootstrap.table.TableBehavior;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.behavior.AnimatedBehavior;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.behavior.AnimatedBehavior.Animation;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.table.toolbars.BootstrapHeadersToolbar;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.table.toolbars.BootstrapNavigationToolbar;

public final class WicketComponentUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final WicketComponentUtils INSTANCE = new WicketComponentUtils();

	public static WicketComponentUtils getInstance() {
		return INSTANCE;
	}

	private WicketComponentUtils() {
		super();
	}

	public <T> BootstrapForm<T> buildBootstrapForm(final String idForm, final IModel<T> formModel, final FormType formType) {
		final BootstrapForm<T> form = new BootstrapForm<>(idForm);
		form.add(new FormBehavior().type(formType));
		prepareComponent(form);
		return form;
	}

	public FormGroup buildFormGroup(final String idFormGroup, final Component component, final IModel<String> modelFormGroup) {
		return buildFormGroup(idFormGroup, component, modelFormGroup, null);
	}

	public FormGroup buildFormGroup(final String idFormGroup, final Component component, final IModel<String> modelFormGroup, final Size size) {
		final FormGroup formGroup = new FormGroup(idFormGroup, modelFormGroup);
		if (size != null) {
			formGroup.size(size);
		}
		prepareComponent(formGroup);
		formGroup.add(prepareComponent(component));
		return formGroup;
	}

	public Component prepareComponent(final Component component) {
		if (Objects.nonNull(component)) {
			component.setMarkupId(component.getId()).setOutputMarkupId(true).setOutputMarkupPlaceholderTag(true);
		}
		return component;
	}

	public <E, H> void prepareDataTable(final DataTable<E, H> table) {
		prepareDataTable(table, null);
	}

	public <E, H> void prepareDataTable(final DataTable<E, H> table, final ISortStateLocator<H> stateLocator) {
		final BootstrapHeadersToolbar<H> toolbar = new BootstrapHeadersToolbar<H>(table, stateLocator);
		final BootstrapNavigationToolbar navigationToolbar = new BootstrapNavigationToolbar(table);
		prepareComponent(table);
		prepareComponent(toolbar);
		prepareComponent(navigationToolbar);
		table.addTopToolbar(toolbar);
		table.addBottomToolbar(navigationToolbar);
		table.add(new TableBehavior().bordered().hover());
		table.add(new AnimatedBehavior(Animation.pulse));
	}
}
