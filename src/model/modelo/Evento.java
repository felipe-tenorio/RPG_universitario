package model.modelo;

import java.util.Map;

public class Evento {
    private String nome;
    private String descricao;
    private String condicaoAtivacao;
    private Map<String, Double> efeitos;

    public Evento(String nome, String desc, String cond, Map<String, Double> efeitos){
        this.nome = nome;
        this.descricao = desc;
        this.condicaoAtivacao = cond;
        this.efeitos = efeitos;
    }

    //Lê o mapa de efeitos gerados pelo evento e aplica diretamente aos atributos correspondentes do jogador
    public void aplicarConsequencia(Jogador jogador) {
        efeitos.forEach((chave, valor) -> {
            switch (chave) {
                case "energia":
                    jogador.setEnergia(jogador.getEnergia()+valor.intValue());
                    break;
                case "saude":
                    jogador.setSaude(jogador.getSaude()+valor.intValue());
                    break;
                case "nivelConhecimento":
                    jogador.setNivelConhecimento(jogador.getNivelConhecimento()+valor.intValue());
                    break;
                case "vontadeDeTrancar":
                    jogador.setVontadeDeTrancar(jogador.getVontadeDeTrancar()+valor.intValue());
                    break;
                case "dinheiro":
                    jogador.setDinheiro(jogador.getDinheiro()+valor);
                    break;
                case "desempenhoAcademico":
                    jogador.setDesempenhoAcademico(jogador.getDesempenhoAcademico()+valor);
                    break;
                default:
                    System.out.println("Erro");
                    break;
            }
        });
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

    public String getCondicaoAtivacao() {
        return condicaoAtivacao;
    }

    public void setCondicaoAtivacao(String condicaoAtivacao) {
        this.condicaoAtivacao = condicaoAtivacao;
    }

    public Map<String, Double> getEfeitos() {
        return efeitos;
    }

    public void setEfeitos(Map<String, Double> efeitos) {
        this.efeitos = efeitos;
    }
}
