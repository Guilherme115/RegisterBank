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


      sistema.exibirEntidades();

        sistema.inicializarEntidades();
        DataOfPerson dataOfPerson = new DataOfPerson(sistema);
        dataOfPerson.calcularSaldo();
        for (PessoaCity entidade : sistema.getEntidades()) {
            sistema.verificarPessoaPorID(entidade.getIdOfUser());
        }
        dataOfPerson.fazerTransferencia();

    }


}




