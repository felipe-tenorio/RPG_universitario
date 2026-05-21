package controller.modelcontrollers;

import java.util.Map;

import model.modelo.Evento;

public class EventoController {
	private Evento evento;
	
	public EventoController(String nome, String descricao, String condicaoAtivacao, Map<String, Double> efeitos) {
		evento = new Evento(nome, descricao, condicaoAtivacao, efeitos);
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
