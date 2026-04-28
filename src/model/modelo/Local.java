package model.modelo;

import java.util.List;

public class Local {
    private String nome;
    private String descricao;
    private List<Personagem> npcsPresentes;

    public Local(String nome, String desc, List<Personagem> npcs) {
        this.nome = nome;
        this.descricao = desc;
        this.npcsPresentes = npcs;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Personagem> getNpcsPresentes() {
        return npcsPresentes;
    }

    public void setNpcsPresentes(List<Personagem> npcsPresentes) {
        this.npcsPresentes = npcsPresentes;
    }
}