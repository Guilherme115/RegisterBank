package Dominios;

import DateExibe.InicilizandoArrays;

import java.util.UUID;

public abstract class PessoaCity {
    protected static double SaldoBancarioCity = 0;
    public String nameOfPerson;
    private String idOfUser;  // Corrigido para String
    String bankOfPerson;

    public PessoaCity(String nameOfPerson, String bankOfPerson) {
        this.nameOfPerson = nameOfPerson;
        this.bankOfPerson = bankOfPerson;
        this.idOfUser = gerarId();
        InicilizandoArrays.adicionarID(this.idOfUser);
    }

    protected static String gerarId() {
            int id = (int) (Math.random() * 90000000) + 10000000; // Garante um número de 8 dígitos
            return String.valueOf(id);
        }

    public static double getSaldoBancarioCity() {
        return SaldoBancarioCity;
    }

    public static void setSaldoBancarioCity(double saldo) {
        SaldoBancarioCity = saldo;
    }






    public String getIdOfUser() { // Criando getter para acessar o ID
        return idOfUser;
    }
    @Override
    public String toString() {
        return "Nome: " + nameOfPerson +
                "\nBanco: " + bankOfPerson +
                "\nID: " + idOfUser;
    }
}
