package controller.modelcontrollers;

import model.modelo.Local;
import model.modelo.Professor;

public class ProfessorController {
	private Professor professor;
	
	public ProfessorController(String nome, Local local, Double rigidez, String fala) {
		professor = new Professor(nome, local, rigidez, fala);
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
