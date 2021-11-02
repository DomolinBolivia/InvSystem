package com.edv.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="holaMundo")
@SessionScoped
public class HolaMundo {
	private String saludo="test de hcoarite";
	
	private String saludoMenu = "Saludo desde menu";

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}	

}
