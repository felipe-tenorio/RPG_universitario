package controller.modelcontrollers;

import model.modelo.CalendarioLetivo;

public class CalendarioController {
	private CalendarioLetivo calendario;
	
	public CalendarioController() {
		calendario = new CalendarioLetivo();
	}
	
	public CalendarioLetivo getCalendario() {
		return calendario;
	}
	
	public void setCalendario(CalendarioLetivo calendario) {
		this.calendario = calendario;
	}
}
