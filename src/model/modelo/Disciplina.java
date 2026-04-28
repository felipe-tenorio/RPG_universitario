package model.modelo;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private Professor professor;
    private int semestre;
    private String status;

    public Disciplina(String nome, int ch, Professor professor, int sem, String status) {
        this.nome = nome;
        this.cargaHoraria = ch;
        this.professor = professor;
        this.semestre = sem;
        this.status = status;
    }

    //Registra uma nova nota para o jogador nesta disciplina através da matrícula.
    public void registrarNota(Matricula matricula, double valor) {
        Map<Disciplina, List<Double>> disciplinas = matricula.getNotas();

        // Verifica se a disciplina já possui uma lista de notas iniciada
        if (disciplinas.containsKey(this)){
            List<Double> notas = disciplinas.get(this);
            notas.add(valor);
            disciplinas.put(this, notas);
            matricula.setNotas(disciplinas);
        } else {
            // Caso seja a primeira nota, cria uma nova lista de notas para essa disciplina
            List<Double> notas = new ArrayList<>();
            notas.add(valor);
            disciplinas.put(this, notas);
        }
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor(){
        return professor;
    }

    public void setProfessor(Professor professor){
        this.professor = professor;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}