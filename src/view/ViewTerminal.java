package view;

import model.modelo.Jogador;

import java.util.InputMismatchException;
import java.util.Scanner;

//Esse classe toda no geral ainda precisa ser remodelada
public class ViewTerminal {
    private Scanner scanner;

    public ViewTerminal() {
        this.scanner = new Scanner(System.in);
    }

    //Exibe qualquer mensagem de texto
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    // Input do nome do jogador
    public String pedirNomeJogador() {
        System.out.print("Digite o nome do seu calouro: ");
        return scanner.nextLine().trim();
    }

    //Exibe o menu inicial antes do jogo começar e retorna a opção escolhida.
    //Possui tratamento para evitar que o programa quebre se o usuário digitar letras no lugar de números.
    public int mostrarMenuPrincipal() {
        int opcao = -1;
        while (opcao == -1) {
            System.out.println("\n           Menu Principal              ");
            System.out.println("[1] Iniciar Novo Jogo");
            System.out.println("[2] Carregar Jogo Salvo");
            System.out.println("[3] Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Para limpa o buffer do teclado
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números válidos!");
                scanner.nextLine(); // Limpa a entrada inválida do buffer
            }
        }
        return opcao;
    }

    //Renderiza na tela o quadro de status atualizado do jogador.
    public void exibirStatus(Jogador jogador) {
        System.out.println("\n        STATUS DO ALUNO            ");
        System.out.println("Aluno: " + jogador.getNome());
        System.out.println("Local: " + (jogador.getLocalizacao() != null ? jogador.getLocalizacao().getNome() : "Desconhecido"));
        System.out.println("Energia: " + jogador.getEnergia() + "/100");
        System.out.println("Saúde: " + jogador.getSaude() + "/100");
        System.out.println("Conhecimento: " + jogador.getNivelConhecimento());
        System.out.println("Vontade de Trancar: " + jogador.getVontadeDeTrancar() + "/100");
        System.out.println("Dinheiro: R$ " + String.format("%.2f", jogador.getDinheiro()));
        System.out.println("----------------------------------");
    }

    //  Ações disponíveis no turno e retorna a escolha.

    /*Ainda precisa remodelar esse metodo para ficar um loop de ações,
      que só termina quando passa a unidade (que é quando já foram feitas as provas da unidade) */
    public int mostrarMenuDeAcoes() {
        int acao = -1;
        while (acao == -1) {
            System.out.println("\n--- O QUE VOCÊ DESEJA FAZER AGORA? ---");
            System.out.println("[1] Estudar (- Energia, + Conhecimento)");
            System.out.println("[2] Ir à Cantina (Gastar dinheiro para recuperar energia/saúde)");
            System.out.println("[3] Fazer Avaliação (Testar seu conhecimento contra um professor)");
            System.out.println("[4] Interagir com animal (Diminuir vontade de trancar o curso)");
            System.out.println("[5] Pegar ônibus (Mudar de Localização)");
            System.out.println("[8] Salvar Jogo");
            System.out.println("[9] Sair para o Menu Principal");
            System.out.print("Sua ação: ");

            try {
                acao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas o número da ação desejada!");
                scanner.nextLine();
            }
        }
        return acao;
    }
}