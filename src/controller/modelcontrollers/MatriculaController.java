package controller.modelcontrollers;

import model.modelo.Matricula;

public class MatriculaController {
	private Matricula matricula;
	
	public MatriculaController() {
		matricula = new Matricula();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
}
