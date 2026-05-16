package controller;

import model.modelo.*;
import view.ViewTerminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidaController {
    //Aqui é pra ter um atributo com a view, pra o controller conter a view
    private ViewTerminal view;
    private Jogador jogadorAtivo;

    private List<Local> locais;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    private List<Animal> animais;
    private List<EventoAleatorio> eventosAleatorios;

    public PartidaController(ViewTerminal view) {
        this.view = view;
        inicializarMundo();
    }

    private void inicializarMundo() {
        this.locais = new ArrayList<>();
        this.professores = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.animais = new ArrayList<>();
        this.eventosAleatorios = new ArrayList<>();

        //Locais
        Local campus = new Local("Campus", "Andando pelos corredores do campus.", new ArrayList<>());
        Local salaDeAula = new Local("Sala de Aula", "Local de estudo diário.", new ArrayList<>());
        Local cantina = new Local("Cantina", "A pausa pro café e o lanche.", new ArrayList<>());
        Local laboratorio = new Local("Laboratório", "Local de sofrimento, mas que gera conhecimento.", new ArrayList<>());
        Local colegiado = new Local("Colegiado", "Onde a Maeli pode te salvar.", new ArrayList<>());
        Local pontoDeOnibus = new Local("Ponto de Ônibus", "Sempre lotado no fim do dia.", new ArrayList<>());

        locais.add(campus);
        locais.add(salaDeAula);
        locais.add(cantina);
        locais.add(laboratorio);
        locais.add(colegiado);
        locais.add(pontoDeOnibus);

        //Professores (Só coloquei qualquer coisa por enquanto)
        Professor profProgramacao = new Professor("Ana Lúcia", salaDeAula, 6.5, "A lista vale ponto extra.");
        Professor profCalculo = new Professor("Cristiano", salaDeAula, 9.0, "A prova estava fácil, vocês que não estudaram.");
        professores.add(profProgramacao);
        professores.add(profCalculo);

        // Disciplinas
        // Vai ter no max 3 disciplinas por semestre
        Disciplina miProgramacao = new Disciplina("MI - Programação", 90, profProgramacao, 1, "Disponível");
        Disciplina calculo1 = new Disciplina("Cálculo I", 60, profCalculo, 1, "Disponível");
        disciplinas.add(miProgramacao);
        disciplinas.add(calculo1);

        // Animais do Campus
        Animal dog = new Animal("Caramelo", cantina, "cachorro");
        Animal gato = new Animal("Mingau", colegiado, "gato");
        animais.add(dog);
        animais.add(gato);

        // Eventos Aleatórios
        Map<String, Double> efeitosMilagre = new HashMap<>();
        efeitosMilagre.put("nivelConhecimento", 20.0);
        EventoAleatorio milagreAcademico = new EventoAleatorio(
                "Milagre Acadêmico",
                "Caiu exatamente o assunto que você estudou!",
                "semana de prova",
                efeitosMilagre,
                0.1f
        );

        Map<String, Double> efeitosFila = new HashMap<>();
        efeitosFila.put("energia", -10.0);
        EventoAleatorio filaCantina = new EventoAleatorio(
                "Fila Gigante na Cantina",
                "Você perdeu muito tempo e energia esperando sua vez.",
                "sempre",
                efeitosFila,
                0.3f
        );

        eventosAleatorios.add(milagreAcademico);
        eventosAleatorios.add(filaCantina);
    }

    // Esse metodo vai ser desenvolvido para começar um jogo
    public void iniciarJogo() {

        //A view que pega o nome do Jogador
        String nome = view.pedirNomeJogador();
        this.jogadorAtivo = new Jogador(nome);
        this.jogadorAtivo.setLocal(locais.get(0)); // O jogador começa no campus

        loopPrincipal();
    }

    //Teoricamente, é pra gente fazer a logica do jogo aqui
    private void loopPrincipal() {
        boolean jogoRodando = true;

        while(jogoRodando) {

            // Trava de segurança temporária para evitar loop infinito ao rodar no estado atual
            jogoRodando = false;
        }
    }
}