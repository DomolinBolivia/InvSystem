package com.edv.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Named
@RequestScoped
public class UserDataBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5586322849442249444L;

	private String userName;

	@PostConstruct
	public void init() {
		System.out.println("Recuerando datos de usuario...");
	}
	
	

}
