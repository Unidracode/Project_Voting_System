package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * requisito GerenciamentoVotacao.
 */

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfsComputados = new ArrayList<String>();

  /**
   * GerenciamentoVotacao.
   */

  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata newPessoa = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(newPessoa);
  }

  /**
   * GerenciamentoVotacao.
   */

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (pessoa.getCpf() == cpf) {
        System.out.println("Pesoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora newPessoa = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(newPessoa);
  }

  /**
   * GerenciamentoVotacao.
   */

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : cpfsComputados) {
      if (Objects.equals(cpf, cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }

    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numeroPessoaCandidata) {
        pessoa.receberVoto();
        break;
      }
    }
    cpfsComputados.add(cpfPessoaEleitora);
  }

  /**
   * GerenciamentoVotacao.
   */

  public void mostrarResultado() {
    int totalVotos = cpfsComputados.size();

    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }
    for (pessoaCandidata pessoa : pessoasCandidatas) {
      int votesReceived = pessoa.getVotos();
      double votesPercentage = ((double) votesReceived / totalVotos) * 100;
      int votosContados = (int) Math.round(votesPercentage);

      System.out.printf("Nome: %s - %s votos ( %s%% )", pessoa.getNome(), votesReceived,
          votosContados);
    }
    System.out.println("Total de votos: " + totalVotos);
  }
}