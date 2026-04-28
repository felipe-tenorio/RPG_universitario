package model.testes;

import model.modelo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class Testes {

    //-
    // TESTES DA CLASSE ANIMAL
    //-
    @Test
    public void testAnimalReceberCarinho() {
        Animal animal = new Animal("Rex", null, "cachorro");
        assertEquals(0, animal.getHumor());

        animal.receberCarinho();
        assertEquals(5, animal.getHumor());
    }

    @Test
    public void testAnimalEmitirSom() {
        Animal cachorro = new Animal("Rex", null, "cachorro");
        Animal gato = new Animal("Mingau", null, "gato");
        Animal passaro = new Animal("Piu", null, "passaro");

        //Já que é uma função void que não tem retorno, só foi testada se o código roda
        assertDoesNotThrow(cachorro::emitirSom);
        assertDoesNotThrow(gato::emitirSom);
        assertDoesNotThrow(passaro::emitirSom);
    }

    // -
    // TESTES DA CLASSE MATRICULA
    //-
    @Test
    public void testMatriculaCursarDisciplina() {
        Matricula matricula = new Matricula();
        Disciplina disciplina = new Disciplina("Cálculo I", 60, null, 1, "Cursando");

        matricula.cursarDisciplina(disciplina);

        assertTrue(matricula.getDisciplinasMatriculadas().contains(disciplina));
        assertEquals(1, matricula.getDisciplinasMatriculadas().size());
    }

    //-
    // TESTES DA CLASSE DISCIPLINA
    //-
    @Test
    //Confirma se o registro sequencial de notas em uma mesma disciplina ocorre corretamente
    public void testDisciplinaRegistrarNota() {
        Matricula matricula = new Matricula();
        Disciplina disciplina = new Disciplina("Física", 60, null, 1, "Cursando");

        // Teste de primeira nota para a disciplina
        disciplina.registrarNota(matricula, 8.5);
        assertTrue(matricula.getNotas().containsKey(disciplina));
        assertEquals(1, matricula.getNotas().get(disciplina).size());
        assertEquals(8.5, matricula.getNotas().get(disciplina).get(0));

        // Teste de adição de nova nota à lista existente
        disciplina.registrarNota(matricula, 7.0);
        assertEquals(2, matricula.getNotas().get(disciplina).size());
        assertEquals(7.0, matricula.getNotas().get(disciplina).get(1));
    }

    //-
    // TESTES DA CLASSE CALENDARIO LETIVO
    //-
    @Test
    public void testCalendarioPassarUnidadeTodasComProva() {
        CalendarioLetivo calendario = new CalendarioLetivo();
        Matricula matricula = new Matricula();
        Disciplina d1 = new Disciplina("Programação", 60, null, 1, "Cursando");

        matricula.cursarDisciplina(d1);
        d1.registrarNota(matricula, 7.0); // Garante que a disciplina tem a nota da unidade atual (1)

        calendario.passarUnidade(matricula);

        assertEquals(2, calendario.getUnidadeAtual());
    }

    @Test
    public void testCalendarioPassarUnidadeFaltandoProva() {
        CalendarioLetivo calendario = new CalendarioLetivo();
        Matricula matricula = new Matricula();
        Disciplina d1 = new Disciplina("Programação", 60, null, 1, "Cursando");

        matricula.cursarDisciplina(d1); // Cursando, mas sem nota registrada

        calendario.passarUnidade(matricula);

        // A unidade não deve avançar
        assertEquals(1, calendario.getUnidadeAtual());
    }

    @Test
    public void testCalendarioPassarSemestreAprovado() {
        CalendarioLetivo calendario = new CalendarioLetivo();
        Jogador jogador = new Jogador("Bixo");
        Matricula matricula = jogador.getMatricula(); // Aproveita a matricula inicializada do jogador
        matricula.setCalendario(calendario);

        Disciplina d1 = new Disciplina("Programação", 60, null, 1, "Cursando");
        matricula.cursarDisciplina(d1);

        // Preenche os requisitos: mínimo de 3 notas e média >= 7.0
        d1.registrarNota(matricula, 7.0);
        d1.registrarNota(matricula, 8.0);
        d1.registrarNota(matricula, 9.0);

        jogador.setNivelConhecimento(50);
        calendario.passarSemestre(matricula, jogador);

        assertEquals(2, calendario.getSemestreAtual());
        assertEquals(1, calendario.getUnidadeAtual());
        assertEquals(0, jogador.getNivelConhecimento());
        assertTrue(matricula.getDisciplinasMatriculadas().isEmpty());
        assertTrue(matricula.getDisciplinasCursadas().contains(d1));
    }

    //-
    // TESTES DA CLASSE EVENTO
    //-
    @Test
    public void testEventoAplicarConsequencia() {
        Jogador jogador = new Jogador("Bixo");
        jogador.setEnergia(50);
        jogador.setSaude(50);
        jogador.setNivelConhecimento(50);

        Map<String, Double> efeitos = new HashMap<>();
        efeitos.put("energia", 20.0);

        Evento evento = new Evento("Dormiu bem", "Recuperou energia", "nenhuma", efeitos);
        evento.aplicarConsequencia(jogador);

        // Verifica se APENAS a energia foi alterada
        assertEquals(70, jogador.getEnergia());
        assertEquals(50, jogador.getSaude());
        assertEquals(50, jogador.getNivelConhecimento());
    }

    //-
    // TESTES DA CLASSE EVENTO ALEATORIO
    //-
    @Test
    public void testEventoAleatorioDecidirOcorrencia() {
        EventoAleatorio eventoCerto = new EventoAleatorio("Certo", "Vai ocorrer", "cond", new HashMap<>(), 1.0f);
        assertTrue(eventoCerto.decidirOcorrencia());

        EventoAleatorio eventoImpossivel = new EventoAleatorio("Impossível", "Não vai", "cond", new HashMap<>(), 0.0f);
        assertFalse(eventoImpossivel.decidirOcorrencia());
    }

    //-
    // TESTES DA CLASSE PROFESSOR
    //-
    @Test
    public void testProfessorFalar() {
        Professor professor = new Professor("Girafales", null, 0.8, "Silêncio!");
        //Como é uma função void, só foi testado se ela roda
        assertDoesNotThrow(professor::falar);
    }

    //-
    // TESTES DA CLASSE JOGADOR
    //-
    @Test
    public void testJogadorAdquirirLanchesComDinheiro() {
        Jogador jogador = new Jogador("Bixo");
        Local cantina = new Local("cantina", "Cantina da faculdade", new ArrayList<>());
        jogador.setLocal(cantina);
        jogador.setDinheiro(20.0);

        jogador.adquirirLanches(5.0);

        assertEquals(15.0, jogador.getDinheiro());
    }

    @Test
    public void testJogadorAdquirirLanchesSemDinheiro() {
        Jogador jogador = new Jogador("Bixo");
        Local cantina = new Local("cantina", "Cantina da faculdade", new ArrayList<>());
        jogador.setLocal(cantina);
        jogador.setDinheiro(3.0);

        jogador.adquirirLanches(5.0);

        assertEquals(3.0, jogador.getDinheiro()); // O dinheiro não pode ter diminuído
    }

    @Test
    public void testJogadorPegarOnibus() {
        Jogador jogador = new Jogador("Bixo");
        Local ponto = new Local("Uefs", "Ponto final", new ArrayList<>());
        jogador.setDinheiro(5.0);

        jogador.pegarOnibus(ponto);

        assertEquals(2.0, jogador.getDinheiro());
        assertEquals(ponto, jogador.getLocalizacao());

        // Teste de viagem sem saldo suficiente
        Local casa = new Local("Casa", "Minha casa", new ArrayList<>());
        jogador.pegarOnibus(casa);

        assertEquals(2.0, jogador.getDinheiro());
        assertEquals(ponto, jogador.getLocalizacao()); // Não deve ter mudado de local
    }

    @Test
    public void testJogadorPedirAjudaMaeli() {
        Jogador jogador = new Jogador("Bixo");
        assertEquals(0, jogador.getNivelConhecimento());

        jogador.pedirAjudaMaeli();
        assertEquals(5, jogador.getNivelConhecimento());
    }

    @Test
    public void testJogadorEstudar() {
        Jogador jogador = new Jogador("Bixo");
        jogador.setEnergia(100);
        jogador.setNivelConhecimento(0);

        jogador.estudar();

        assertEquals(5, jogador.getNivelConhecimento());
        assertEquals(95, jogador.getEnergia());
    }

    @Test
    public void testJogadorAcariciarAnimal() {
        Jogador jogador = new Jogador("Bixo");
        jogador.setVontadeDeTrancar(20);

        Animal animal = new Animal("Mingau", null, "gato");
        animal.setHumor(10); // Inicializa com 10

        jogador.acariciarAnimal(animal);

        // Cálculo da vontadeDeTrancar: 20 - (int)(2 + (humor inicial)*0.1)
        // 20 - (int)(2 + 10*0.1) -> 20 - 3 = 17
        assertEquals(17, jogador.getVontadeDeTrancar());

        // O humor do animal deve subir +5
        assertEquals(15, animal.getHumor());
    }

    @Test
    public void testJogadorFazerAvaliacao() {
        Jogador jogador = new Jogador("Bixo");
        jogador.setNivelConhecimento(60);

        Professor prof = new Professor("Carrasco", null, 8, "Zero!");
        Disciplina disc = new Disciplina("Cálculo I", 60, prof, 1, "Cursando");

        jogador.fazerAvaliacao(disc);

        assertTrue(jogador.getMatricula().getNotas().containsKey(disc));
        assertEquals(1, jogador.getMatricula().getNotas().get(disc).size());

        double notaFinal = jogador.getMatricula().getNotas().get(disc).get(0);
        assertTrue(notaFinal >= 0.0 && notaFinal <= 10.0);
    }
}