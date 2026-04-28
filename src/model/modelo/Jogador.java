package model.modelo;

import java.util.HashMap;
import java.util.Map;

public class Jogador {
    private String nome;
    private Matricula matricula;
    private Local local;

    private int saude;
    private int energia;
    private int nivelConhecimento;
    private int vontadeDeTrancar;
    private double dinheiro;
    private double desempenhoAcademico;

    public Jogador(String nome){
        this.nome = nome;
        this.energia = 100;
        this.saude = 100;
        this.matricula = new Matricula();
        this.nivelConhecimento = 0;
        this.vontadeDeTrancar = 0;
        this.dinheiro = 20.0;
        this.desempenhoAcademico = 0.0;
        this.local = null;
    }


    //Ação de comprar lanches. Só funciona se o jogador estiver no local "cantina" e possuir dinheiro suficiente.
    public void adquirirLanches(double preco) {
            if (this.local.getNome().equals("cantina")) {
                if (this.dinheiro >= preco) {
                    this.setDinheiro(this.getDinheiro()-preco);
                } else {
                    System.out.println("Sem dinheiro");
                }
            }
    }

    //Altera a localização do jogador pagando a passagem.
    public void pegarOnibus(Local paraOndeVai) {
        if (this.dinheiro < 3.0) {
            System.out.println("Sem dinheiro.");
        } else {
            this.setDinheiro(this.getDinheiro()-3.0);
            this.setLocal(paraOndeVai);
        }
    }

    public void pedirAjudaMaeli() {
        this.setNivelConhecimento(this.getNivelConhecimento()+5);
    }

    //A nota é calculada baseando-se no conhecimento atual do aluno contra
    //o rigor do professor responsável pela matéria, com a adição de um fator de sorte aleatório.
    public void fazerAvaliacao(Disciplina disciplina) {
        double rigor = disciplina.getProfessor().getNivelRigor()*10;
        int conhecimento = this.getNivelConhecimento();


        double notaBase = (conhecimento - rigor) * 0.1 + 7.0;

        //Variavel de sorte
        double fatorSorte = (Math.random() * 2) - 1; //
        double notaFinal = notaBase + fatorSorte;

        //Limita a nota de 0 a 10
        if (notaFinal > 10.0) notaFinal = 10.0;
        if (notaFinal < 0.0) notaFinal = 0.0;

        disciplina.registrarNota(this.getMatricula(), notaFinal);
    }

    //Ação de estudo que consome energia e provê conhecimento.
    public void estudar(){
        this.setNivelConhecimento(this.getNivelConhecimento()+5);
        this.setEnergia(this.getEnergia()-5);
    }

    //Mecânica de redução de estresse
    public void acariciarAnimal(Animal animal) {
        this.setVontadeDeTrancar(this.getVontadeDeTrancar()-(int)(2+animal.getHumor()*0.1));
        animal.receberCarinho();
    }

    /* Getters e setters */
    public String getNome() {
        return nome;
    }
    public Integer getEnergia(){
        return energia;
    }
    public Integer getSaude(){
        return saude;
    }
    public Integer getNivelConhecimento(){
        return nivelConhecimento;
    }
    public Integer getVontadeDeTrancar(){
        return vontadeDeTrancar;
    }
    public Double getDinheiro(){
        return dinheiro;
    }
    public Double getDesempenhoAcademico(){
        return desempenhoAcademico;
    }
    public Local getLocalizacao(){
        return local;
    }
    public Matricula getMatricula(){
        return matricula;
    }

    public void setMatricula(Matricula matricula){
        this.matricula = matricula;
    }
    public void setLocal(Local local){
        this.local = local;
    }
    public void setEnergia(int x){
        if (x > 100){
            this.energia = 100;
        } else if (x < 0) {
            this.energia = 0;
        } else {
            this.energia = x;
        }
    }
    public void setSaude(int x){
        if (x > 100){
            this.saude = 100;
        } else if (x < 0) {
            this.saude = 0;
        } else {
            this.saude = x;
        }
    }
    public void setNivelConhecimento(int x){
        if (x > 100){
            this.nivelConhecimento = 100;
        } else if (x < 0) {
            this.nivelConhecimento = 0;
        } else {
            this.nivelConhecimento = x;
        }
    }
    public void setVontadeDeTrancar(int x){
        if (x > 100){
            this.vontadeDeTrancar = 100;
        } else if (x < 0) {
            this.vontadeDeTrancar = 0;
        } else {
            this.vontadeDeTrancar = x;
        }
    }
    public void setDinheiro(double x){
        if (x < 0) {
            this.dinheiro = 0.0;
        } else {
            this.dinheiro = x;
        }
    }
    public void setDesempenhoAcademico(double x){
        this.desempenhoAcademico = x;
    }

}