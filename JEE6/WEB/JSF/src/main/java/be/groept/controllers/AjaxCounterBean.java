package be.groept.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class AjaxCounterBean {
	private int counter = 0;

	public void increment(){
		counter++;		
	}
	
	public int getCounter(){
		return counter;
	}
	
}
