package controller.modelcontrollers;

import model.modelo.Jogador;

public class JogadorController {
	private Jogador jogador;
	
	public JogadorController(String nome) {
		jogador = new Jogador(nome);
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
}
