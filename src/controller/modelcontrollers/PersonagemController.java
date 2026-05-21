package controller.modelcontrollers;

import model.modelo.Local;
import model.modelo.Personagem;

public class PersonagemController {
	private Personagem personagem;
	
	public PersonagemController(String nome, Local local) {
		personagem = new Personagem(nome, local);
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
}
