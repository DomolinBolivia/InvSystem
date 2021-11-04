package com.edv.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Named
@RequestScoped
public class LoginBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3398680793998450936L;

	private String user = "hcoarite";
	
	private String pass = "123456789";
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String login() {
		System.out.println("Ingreso a login...");
		return "/template/template.xhtml";
	}
}
