package com.edv.view.menu;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@RequestScoped
public class MenuView {

	private MenuModel model;

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();

		// First submenu
		DefaultSubMenu firstSubmenu = DefaultSubMenu.builder().label("Options").build();

		DefaultMenuItem item = DefaultMenuItem.builder().value("Save (Non-Ajax)").icon("pi pi-save").ajax(false)
				.command("#{menuView.save}").update("messages").build();
		firstSubmenu.getElements().add(item);

		item = DefaultMenuItem.builder().value("Update").icon("pi pi-refresh").command("#{menuView.update}")
				.update("messages").build();
		firstSubmenu.getElements().add(item);

		item = DefaultMenuItem.builder().value("Delete").icon("pi pi-times").command("#{menuView.delete}").build();
		firstSubmenu.getElements().add(item);

		model.getElements().add(firstSubmenu);

		// Second submenu
		DefaultSubMenu secondSubmenu = DefaultSubMenu.builder().label("Navigations").build();

		item = DefaultMenuItem.builder().value("Website").url("http://www.primefaces.org").icon("pi pi-external-link")
				.build();
		secondSubmenu.getElements().add(item);

		item = DefaultMenuItem.builder().value("Internal").icon("pi pi-upload").command("#{menuView.redirect}").build();
		secondSubmenu.getElements().add(item);

		model.getElements().add(secondSubmenu);
	}

	public MenuModel getModel() {
		return model;
	}

	public void redirect() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath());
	}

	public void save() {
		addMessage("Save", "Data saved");
	}

	public void update() {
		addMessage("Update", "Data updated");
		System.out.println("Mensaje actualizado..");
	}

	public void delete() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Delete", "Data deleted");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String testLoad() {
		System.out.println("Test de carga de pagina");
		return "/page/content.xhtml";
	}
	public String testLoad1() {
		System.out.println("Test de carga de pagina");
		return "/page/testPage.xhtml";
	}
	
	public void test() {
		System.out.println("....................................................");
	}
	public void test1() {
		System.out.println("*****************************************************");
	}
}