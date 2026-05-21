package controller.modelcontrollers;

import java.util.List;

import model.modelo.Local;
import model.modelo.Personagem;

public class LocalController {
	private Local local;
	
	public LocalController(String nome, String descricao, List<Personagem> npcs) {
		local = new Local(nome, descricao, npcs);
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
}
