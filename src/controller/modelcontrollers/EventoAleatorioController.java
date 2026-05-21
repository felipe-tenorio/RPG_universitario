package controller.modelcontrollers;

import java.util.Map;

import model.modelo.EventoAleatorio;

public class EventoAleatorioController {
	private EventoAleatorio aleatorio;
	
	public EventoAleatorioController(String nome, String descricao, String condicaoAtivacao, Map<String, Double> efeitos, Float probabilidade){
		aleatorio = new EventoAleatorio(nome, descricao, condicaoAtivacao, efeitos, probabilidade);
	}

	public EventoAleatorio getAleatorio() {
		return aleatorio;
	}

	public void setAleatorio(EventoAleatorio aleatorio) {
		this.aleatorio = aleatorio;
	}
}
