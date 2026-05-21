package controller.modelcontrollers;

import model.modelo.Disciplina;
import model.modelo.Professor;

public class DisciplinaController {
	private Disciplina disciplina;
	
	public DisciplinaController(String nomeMateria, int cargahoraria, Professor professor, int semestre, String status) {
		disciplina = new Disciplina(nomeMateria, cargahoraria, professor, semestre, status);
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
