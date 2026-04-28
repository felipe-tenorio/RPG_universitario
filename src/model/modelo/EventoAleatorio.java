package model.modelo;

import java.util.Map;

public class EventoAleatorio extends Evento {
    private float probabilidadeOcorrencia;

    public EventoAleatorio(String nome, String desc, String cond, Map<String, Double> efeitos, Float proba) {
        super(nome, desc, cond, efeitos);
        this.probabilidadeOcorrencia = proba;
    }

    //Usa pseudo-aleatoriedade para determinar se o evento disparou
    public boolean decidirOcorrencia() {
        double aleatorio = Math.random();
        return this.probabilidadeOcorrencia >= aleatorio;
    }

    // Getters and Setters
    public float getProbabilidadeOcorrencia() {
        return probabilidadeOcorrencia;
    }

    public void setProbabilidadeOcorrencia(float probabilidadeOcorrencia) {
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
    }
}