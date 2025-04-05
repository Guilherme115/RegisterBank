package DateExibe;

import Dominios.AçogueiroCity;
import Dominios.PessoaCity;
import ExcpetionMensage.SaldoInsuficienteException;
import java.util.Random;
import java.util.Scanner;

public class DataOfPerson {
    private Scanner ftTransferencia = new Scanner(System.in);
    private Double valorDaTransferencia;
    private Double saldoBancario;
    private String informarID;
    SystemCity sistema = new SystemCity();

    // Construtor sem parâmetros
    public DataOfPerson() {
        saldoBancario = 0.0; // Inicializa o saldo como 0 até ser gerado
    }

    // Método para gerar saldo aleatório
    public void calcularSaldo() {
        Random random = new Random();
        saldoBancario = 100 + (random.nextDouble() * 900); // De 100.0 a 1000.0
        System.out.printf("Saldo bancário gerado: R$%.2f%n", saldoBancario);
    }

    // Método para acessar o saldo
    public Double getSaldoBancario() {
        return saldoBancario;
    }

    // Método para realizar transferência
    public void fazerTransferencia() throws SaldoInsuficienteException {
        System.out.println("Informe o ID de quem voce ira trasnferir");
        System.out.println("IDs cadastrados no sistema:");
        for (String id : sistema.mapaDePessoas.keySet()) {
            System.out.println("- " + id);
informarID = ftTransferencia.nextLine();
if (sistema.mapaDePessoas.containsKey(informarID)) {

    PessoaCity pessoa = sistema.mapaDePessoas.get(informarID);
    if (pessoa.nameOfPerson.equalsIgnoreCase("JUNIOR")){
            System.out.println("Por favor, informe o valor da transferência:");
            valorDaTransferencia = ftTransferencia.nextDouble();
            if (valorDaTransferencia > saldoBancario) {
                throw new SaldoInsuficienteException("Erro: Saldo Insuficiente!");
            } else {
                saldoBancario -= valorDaTransferencia;
                System.out.printf("Transferência de R$%.2f realizada com sucesso!%n", valorDaTransferencia);
                System.out.printf("Novo saldo: R$%.2f%n", saldoBancario);

                double saldoAtual = PessoaCity.getSaldoBancarioCity(); // pega o saldo atual
                double novoSaldo = saldoAtual + valorDaTransferencia;
                PessoaCity.setSaldoBancarioCity(novoSaldo); // atualiza o saldo

                System.out.println("Saldo atualizado do Açougueiro: R$" + PessoaCity.getSaldoBancarioCity());




            }

        }


        if (valorDaTransferencia > saldoBancario) {
            throw new SaldoInsuficienteException("Erro: Saldo Insuficiente!");
        } else {
            saldoBancario -= valorDaTransferencia;
            System.out.printf("Transferência de R$%.2f realizada com sucesso!%n", valorDaTransferencia);
            System.out.printf("Novo saldo: R$%.2f%n", saldoBancario);
        }
    }else {
    System.out.println("ID não encontrado!");
}
    }
}}
