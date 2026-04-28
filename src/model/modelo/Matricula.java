package model.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//armazena a situação acadêmica do jogador
public class Matricula {
    private List<Disciplina> disciplinasMatriculadas;
    private List<Disciplina> disciplinasCursadas;
    private Map<Disciplina, List<Double>> notas;
    private CalendarioLetivo calendario;

    public Matricula() {
        this.disciplinasCursadas = new ArrayList<>();
        this.disciplinasMatriculadas = new ArrayList<>();
        this.notas = new HashMap<>();
        this.calendario = new CalendarioLetivo();
    }

    public void cursarDisciplina(Disciplina materia) {
        List<Disciplina> matriculadas = this.getDisciplinasMatriculadas();
        matriculadas.add(materia);
        this.setDisciplinasMatriculadas(matriculadas);
    }

    // Getters and Setters
    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void setDisciplinasMatriculadas(List<Disciplina> disciplinasMatriculadas) {
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }

    public List<Disciplina> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void setDisciplinasCursadas(List<Disciplina> disciplinasCursadas) {
        this.disciplinasCursadas = disciplinasCursadas;
    }

    public Map<Disciplina, List<Double>> getNotas() {
        return notas;
    }

    public void setNotas(Map<Disciplina, List<Double>> notas) {
        this.notas = notas;
    }

    public CalendarioLetivo getCalendario() {
        return calendario;
    }

    public void setCalendario(CalendarioLetivo calendario) {
        this.calendario = calendario;
    }
}