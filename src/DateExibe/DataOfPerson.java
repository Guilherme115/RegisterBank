package DateExibe;

import Dominios.PessoaCity;
import ExcpetionMensage.SaldoInsuficienteException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class DataOfPerson {
    private final Scanner input = new Scanner(System.in);
    private Double valorDaTransferencia;
    private Double saldoBancario;
    private String dataHoraComoString;
    private final SystemCity sistema;

    public DataOfPerson(SystemCity sistema) {
        this.sistema = sistema;
        saldoBancario = 0.0;
    }

    // Gera saldo aleatório
    public void calcularSaldo() {
        Random random = new Random();
        saldoBancario = 100 + (random.nextDouble() * 900);
        System.out.printf("Saldo bancário gerado: R$%.2f%n", saldoBancario);
    }

    // Atualiza saldo estático da PessoaCity
    public void atualizarValores() {
        double saldoAtual = PessoaCity.getSaldoBancarioCity();
        double novoSaldo = saldoAtual + valorDaTransferencia;
        PessoaCity.setSaldoBancarioCity(novoSaldo);

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        dataHoraComoString = agora.format(formato);

        System.out.println("Saldo atualizado: " + PessoaCity.getSaldoBancarioCity());
    }

    public void exibirComprovante(PessoaCity pessoaCity) {
        System.out.println("===================================================");
        System.out.println("DATA DA TRANSAÇÃO: " + dataHoraComoString);
        System.out.println("DADOS DO BENEFICIADO:\n" + pessoaCity);
        System.out.printf("VALOR DA TRANSAÇÃO: R$%.2f%n", valorDaTransferencia);
    }

    // Método principal
    public void fazerTransferencia() throws SaldoInsuficienteException {
        System.out.println("Informe o ID de quem você irá transferir");

        while (true) {
            System.out.print("Informe o ID: ");
            String informarID = input.nextLine().trim();

            if (sistema.mapaDePessoas.containsKey(informarID)) {
                PessoaCity pessoa = sistema.mapaDePessoas.get(informarID);
                String nome = pessoa.nameOfPerson.toUpperCase();

                if (nome.equals("JUNIOR") || nome.equals("MARIO")) {
                    realizarTransferenciaPara(pessoa);

                    System.out.println("Deseja continuar? (s/n)");
                    String opcao = input.nextLine().trim();
                    if (!opcao.equalsIgnoreCase("s")) break;

                } else {
                    System.out.println("Pessoa não autorizada para transferência.");
                }
            } else {
                System.out.println("ID não encontrado. Tente novamente.");
            }
        }
    }

    // Lógica comum de transferência
    private void realizarTransferenciaPara(PessoaCity pessoa) throws SaldoInsuficienteException {
        System.out.println("Por favor, informe o valor da transferência:");
        valorDaTransferencia = input.nextDouble();
        input.nextLine(); // Limpa buffer

        if (valorDaTransferencia > saldoBancario) {
            throw new SaldoInsuficienteException("Erro: Saldo Insuficiente!");
        }

        saldoBancario -= valorDaTransferencia;
        System.out.printf("Transferência de R$%.2f realizada com sucesso!%n", valorDaTransferencia);
        System.out.printf("Novo saldo: R$%.2f%n", saldoBancario);

        atualizarValores();

        System.out.println("O QUE DESEJA FAZER? \n1 - VER COMPROVANTE \n2 - FAZER NOVA TRANSFERÊNCIA \n3 - SAIR");
        int resposta = input.nextInt();
        input.nextLine();

        if (resposta == 1) {
            exibirComprovante(pessoa);
        } else if (resposta == 3) {
            System.out.println("Encerrando transferência...");
        }
    }
}
