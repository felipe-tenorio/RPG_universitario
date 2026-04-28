package model.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Gerencia o progresso temporal acadêmico do jogador, controlando o avanço
//entre unidades (provas) e semestres letivos.
public class CalendarioLetivo {
    private int semestreAtual;
    private int unidadeAtual;

    public CalendarioLetivo() {
        this.semestreAtual = 1;
        this.unidadeAtual = 1;
    }

    //Avança 1 unidade se o jogador fez todas as provas da unidade
    public void passarUnidade(Matricula matricula) {
        List<Disciplina> matriculadas = matricula.getDisciplinasMatriculadas();
        Map<Disciplina, List<Double>> notasMap = matricula.getNotas();

        if (matriculadas == null || notasMap == null) return;

        boolean todasComProva = true;

        for (Disciplina d : matriculadas) {
            List<Double> notasDaDisciplina = notasMap.get(d);

            if (notasDaDisciplina == null || notasDaDisciplina.size() < this.unidadeAtual) {
                todasComProva = false;
                break;
            }
        }

        if (todasComProva) {
            this.setUnidadeAtual(this.unidadeAtual + 1);
        } else {
            System.out.println("Ainda faltam provas para concluir a unidade.");
        }
    }

    //Avança um semestre de ensino se o jogador tiver realizado provas suficientes
    //em todas as disciplinas nas quais está matriculado e tiver passado em todas elas.
    public void passarSemestre(Matricula matricula, Jogador jogador) {
        List<Disciplina> matriculadas = matricula.getDisciplinasMatriculadas();
        List<Disciplina> cursadas = matricula.getDisciplinasCursadas();
        Map<Disciplina, List<Double>> notasMap = matricula.getNotas();

        if (matriculadas == null || notasMap == null) return;

        boolean aprovadoEmTodas = true;
        List<Disciplina> passadas = new ArrayList<>();

        // Validação de aprovação disciplina por disciplina
        for (Disciplina d : matriculadas) {
            List<Double> notasDaDisciplina = notasMap.get(d);

            // Se não tiver 3 notas, está automaticamente reprovado ou pendente
            if (notasDaDisciplina == null || notasDaDisciplina.size() < 3) {
                aprovadoEmTodas = false;
                continue;
            }

            // Cálculo da média
            double soma = 0;
            for (Double nota : notasDaDisciplina) {
                soma += nota;
            }
            double media = soma / notasDaDisciplina.size();

            if (media >= 7.0) {
                passadas.add(d); // Guarda as disciplinas em que obteve sucesso
            } else {
                aprovadoEmTodas = false;
            }
        }

        // Transfere as matérias concluídas da lista de matriculadas para a lista de cursadas
        matriculadas.removeAll(passadas);
        cursadas.addAll(passadas);

        // Se passou em tudo que estava matriculado, avança de semestre
        if (aprovadoEmTodas && !passadas.isEmpty()) {
            this.setSemestreAtual(this.getSemestreAtual() + 1);
            this.setUnidadeAtual(1);
            jogador.setNivelConhecimento(0);
        } else {
            System.out.println("Você ainda possui pendências em disciplinas matriculadas.");
        }
    }

    // Getters and Setters
    public int getSemestreAtual() {
        return semestreAtual;
    }

    public void setSemestreAtual(int semestreAtual) {
        this.semestreAtual = semestreAtual;
    }

    public int getUnidadeAtual() {
        return unidadeAtual;
    }

    public void setUnidadeAtual(int unidadeAtual) {
        this.unidadeAtual = unidadeAtual;
    }
}