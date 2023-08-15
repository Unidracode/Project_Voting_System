package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe Principal.
 */
public class Principal {

  /**
   * Classe Principal.
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

    int option;
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      option = Integer.parseInt(scanner.nextLine());

      if (option == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidata = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidata = Integer.parseInt(scanner.nextLine());
        gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidata, numeroCandidata);
      }
    } while (option == 1);

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      option = Integer.parseInt(scanner.nextLine());

      if (option == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitora = scanner.nextLine();
        System.out.println("Entre com o CPF da pessoa eleitora:");
        String cpfEleitora = scanner.nextLine();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitora, cpfEleitora);
      }
    } while (option == 1);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      option = Integer.parseInt(scanner.nextLine());

      if (option == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitora = scanner.nextLine();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidata = Integer.parseInt(scanner.nextLine());
        gerenciamentoVotacao.votar(cpfEleitora, numeroCandidata);
      }

      if (option == 2) {
        gerenciamentoVotacao.mostrarResultado();
      }

      if (option == 3) {
        gerenciamentoVotacao.mostrarResultado();
      }
    } while (option != 3);
  }

}