package model.modelo;

public class Animal extends Personagem {
    private int humor;
    private String tipoDeAnimal;

    public Animal(String nome, Local local, String tipo) {
        super(nome, local);
        this.tipoDeAnimal = tipo;
        this.humor = 0;
    }

    //Aumenta o humor do animal em 5 pontos ao receber carinho
    public void receberCarinho() {
        this.setHumor(this.getHumor()+5);
    }

    //Imprime no console o som do animal de acordo com o tipo.
    public void emitirSom() {
        if (this.tipoDeAnimal.equals("cachorro")) {
            System.out.println("Au Au");
        } else if (this.tipoDeAnimal.equals("gato")) {
            System.out.println("Miau");
        } else {
            System.out.println("...");
        }
    }

    // Getters and Setters
    public int getHumor() {
        return humor;
    }

    public void setHumor(int humor) {
        if (humor > 100) {
            this.humor = 100;
        } else if (humor < 0) {
            this.humor = 0;
        } else {
            this.humor = humor;
        }
    }

    public String getTipoDeAnimal() {
        return tipoDeAnimal;
    }

    public void setTipoDeAnimal(String tipoDeAnimal) {
        this.tipoDeAnimal = tipoDeAnimal;
    }
}