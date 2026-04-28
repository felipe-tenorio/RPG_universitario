package model.modelo;

public class Professor extends Personagem {
    private double nivelRigor;
    private final String falaDefault;

    public Professor(String nome, Local local, double rigor, String fala){
        super(nome, local);
        this.nivelRigor = rigor;
        this.falaDefault = fala;
    }

    //Imprime a fala padrão do professor
    public void falar(){
        System.out.println(this.falaDefault+" Não irei responder mais dúvidas!");
    }

    // Getters and Setters

    public double getNivelRigor() {
        return nivelRigor;
    }

    public void setNivelRigor(double nivelRigor) {
        if (nivelRigor > 10) {
            this.nivelRigor = 10;
        } else if (nivelRigor < 1) {
            this.nivelRigor = 1;
        } else{
            this.nivelRigor = nivelRigor;
        }
    }
}