import DateExibe.DataOfPerson;
import DateExibe.InicilizandoArrays;
import DateExibe.SystemCity;
import Dominios.AçogueiroCity;
import Dominios.PessoaCity;
import ExcpetionMensage.SaldoInsuficienteException;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SaldoInsuficienteException {
        SystemCity sistema = new SystemCity();
        DataOfPerson dataOfPerson = new DataOfPerson();

        sistema.inicializarEntidades();

        // Digamos que você pegou o ID da primeira pessoa:
        String id = sistema.getEntidades().get(0).getIdOfUser();

        sistema.verificarPessoaPorID(id);
        dataOfPerson.fazerTransferencia();

    }


}




