package controller.modelcontrollers;

import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.modelo.Animal;
import model.modelo.CalendarioLetivo;
import model.modelo.Disciplina;
import model.modelo.Evento;
import model.modelo.EventoAleatorio;
import model.modelo.Jogador;
import model.modelo.Local;
import model.modelo.Matricula;
import model.modelo.Personagem;
import model.modelo.Professor;

public class InicioController {
	private Jogador jogador;
	private CalendarioLetivo calendario;
	private List<Animal> animais;
	private List<Disciplina> disciplinas;
	private List<Personagem> npcs;
	private List<Professor> professores;
	private List<Local> locais;
	private List<Evento> eventosNormais;
	private List<EventoAleatorio> eventosAleatorios;
	
	public InicioController() {
		jogador = new Jogador(jogador.getNome());
		calendario = new CalendarioLetivo();
		animais = new ArrayList<Animal>();
		disciplinas = new ArrayList<Disciplina>();
		npcs = new ArrayList<Personagem>();
		professores = new ArrayList<Professor>();
		locais = new ArrayList<Local>();
		eventosNormais = new ArrayList<Evento>();
		eventosAleatorios = new ArrayList<EventoAleatorio>();
	}
	
	public void criarAnimal(String nome, Local local, String tipo) {
		animais.add(new Animal(nome, local, tipo));
	}
	
	public void criarDisciplina(String nome, int cargahoraria, Professor professor, int semestre, String status) {
		disciplinas.add(new Disciplina(nome, cargahoraria, professor, semestre, status));
	}
	
	public void criarPersonagem(String nome, Local local) {
		npcs.add(new Personagem(nome, local));
	}
	
	public void criarProfessor(String nome, Local local, Double rigidez, String fala) {
		professores.add(new Professor(nome, local, rigidez, fala));
	}
	
	public void criarLocal(String nome, String descricao) {
		locais.add(new Local(nome, nome, npcs));
	}
	
	public void criarEventosNormais(String nome, String descricao, String condicaoAtivacao, Map<String, Double> efeitos) {
		eventosNormais.add(new Evento(nome, descricao, condicaoAtivacao, efeitos));
	}
	
	public void criarEventosAleatorios(String nome, String descricao, String condicaoAtivacao, Map<String, Double> efeitos, Float probabilidade) {
		eventosAleatorios.add(new EventoAleatorio(nome, descricao, condicaoAtivacao, efeitos, probabilidade));
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public CalendarioLetivo getCalendario() {
		return calendario;
	}

	public void setCalendario(CalendarioLetivo calendario) {
		this.calendario = calendario;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Personagem> getNpcs() {
		return npcs;
	}

	public void setNpcs(List<Personagem> npcs) {
		this.npcs = npcs;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}

	public List<Evento> getEventosNormais() {
		return eventosNormais;
	}

	public void setEventosNormais(List<Evento> eventosNormais) {
		this.eventosNormais = eventosNormais;
	}

	public List<EventoAleatorio> getEventosAleatorios() {
		return eventosAleatorios;
	}

	public void setEventosAleatorios(List<EventoAleatorio> eventosAleatorios) {
		this.eventosAleatorios = eventosAleatorios;
	}
	
	public <E> Object procurarObjeto(String elemento, List<E> listaElementos){
		Object element = new Object();
		for(E elem: listaElementos) {
			if(elem.toString().equals(elemento)) {
				return elem;
			}
			else if(!listaElementos.contains(elem)){
				listaElementos.add(elem);
				element = elem;
				return elem;
			}
		}
		return element;
		
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		InicioController gerador = new InicioController();
		String[] tipoAnimal = {"Cachorro", "Gato"};
		String[] nomeAnimal = {"Scooby", "Penélope", "Rex", "July", "Mateus", "Ambrósio", "Rex", "Thor", "Buddy", "Max", "Charlie",
		        "Rocky", "Toby", "Bolt", "Spike", "Duke",
		        "Zeus", "Apollo", "Sansão", "Brutus", "Simba",
		        "Fred", "Boris", "Lobo", "Marley", "Bidu",
		        "Scooby", "Pluto", "Beethoven", "Laika", "Totó",
		        "Luna", "Mimi", "Felix", "Garfield", "Tom",
		        "Mingau", "Salem", "Bola de Neve", "Frajola", "Marie",
		        "Chanel", "Nina", "Miau", "Oliver", "Lúcifer",
		        "Bella", "Mel", "Pipoca", "Amora", "Fumaça",
		        "Cacau", "Paçoca", "Jade", "Safira", "Lili"};
		
		String[] nomeNpc = {"Ana Silva", "Bruno Costa", "Carla Oliveira", "Daniel Souza", "Eduarda Lima",
		        "Felipe Santos", "Gabriela Pereira", "Henrique Almeida", "Isabela Rocha", "João Pedro",
		        "Karina Martins", "Lucas Ferreira", "Marina Barbosa", "Nicolas Ribeiro", "Olivia Cardoso",
		        "Pedro Henrique", "Quintino Duarte", "Rafaela Nunes", "Samuel Gomes", "Tatiane Azevedo",
		        "Ubiratan Campos", "Vanessa Teixeira", "William Moraes", "Xênia Borges", "Yago Monteiro",
		        "Alice Rodrigues", "Bernardo Lopes", "Camila Freitas", "Diego Castro", "Elaine Neves",
		        "Fabrício Mendes", "Gisele Xavier", "Hugo Farias", "Ingrid Sá", "Júlio César",
		        "Kelly Andrade", "Leonardo Pinto", "Mônica Barreto", "Natália Guimarães", "Otávio Vieira",
		        "Patrícia Leal", "Quésia Dantas", "Renato Carneiro", "Sílvia Fogaça", "Thiago Prado",
		        "Ulisses Magalhães", "Vitória Maciel", "Wilson Batista", "Xerxes Gomes", "Yara Coutinho", "Zélia Tavares"};
		
		String[] nomeProfessor = {"Roberto Carvalho", "Maria Helena", "Antônio Carlos", "Margarida Fonseca", "Francisco Assis",
		        "Tereza Cristina", "José Ricardo", "Vera Lúcia", "Paulo Sérgio", "Fátima Aparecida",
		        "Carlos Eduardo", "Sônia Regina", "Marcos Vinícius", "Rita de Cássia", "Luiz Fernando",
		        "Cristina Maria", "Ricardo José", "Patrícia Helena", "Sérgio Augusto", "Cláudia Regina",
		        "Fernando César", "Luciana Mara", "Eduardo Luís", "Rosângela Maria", "Marcelo Tadeu",
		        "Adriana Beatriz", "Rogério Almeida", "Denise Silveira", "Jorge Wilson", "Elisabeth Cristina"};
		
		gerador.criarLocal("Colegiado", "Apoio ao Aluno");
		gerador.criarLocal("Módulo 3", "Módulo de Engenharia de Computação");
		gerador.criarLocal("Cantina", "Lugar de Alimentação e Socialização do Módulo");
		gerador.criarLocal("Ponto de Ônibus", null);
		List<Local> locais = gerador.getLocais();
		Local colegiado = locais.get(locais.indexOf();
		
		gerador.criarEventosNormais(null, null, null, null);
		
		for(Integer i = 0; i < 10; i++) {
			gerador.criarLocal("Sala 3" +i.toString(), null);
			gerador.criarLocal("Laboratorio 3" +i.toString(), null);
		}
		for(Integer j = 0; j < random.nextInt(5, 50); j++) {
			gerador.criarAnimal(nomeAnimal[random.nextInt(0, nomeAnimal.length)], gerador.getLocais().get(random.nextInt(0, gerador.getLocais().size())), tipoAnimal[random.nextInt(0, tipoAnimal.length)]);
			gerador.criarPersonagem(nomeNpc[random.nextInt(0, nomeNpc.length)], gerador.getLocais().get(random.nextInt(0, gerador.getLocais().size())));
			gerador.criarProfessor(nomeProfessor[random.nextInt(0, nomeProfessor.length)], locais.get(random.nextInt(0, locais.size())), null, null);
		}
		gerador.criarPersonagem(, null);
		for(Integer k = 0; k < random)
	}
}
