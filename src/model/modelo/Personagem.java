package model.modelo;

//Superclasse para tipos mais específicos como Professor e Animal.
public class Personagem {
    private String nome;
    private Local localizacao;

    public Personagem(String nome, Local local) {
        this.nome = nome;
        this.localizacao = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Local getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Local localizacao) {
        this.localizacao = localizacao;
    }
}