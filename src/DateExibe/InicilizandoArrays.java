package DateExibe;

import Dominios.AçogueiroCity;
import Dominios.PessoaCity;

import java.util.ArrayList;
import java.util.List;

public class InicilizandoArrays {
    public static List<String> idsCadastrados = new ArrayList<>();

        public static void adicionarID(String id) {
            idsCadastrados.add(id);
        }
    public static void exibirIDs() {
        for (String id : idsCadastrados) {
            System.out.println(id);
        }



}}






//ArrayList<Entidade> entidades = new ArrayList<>();
//
//        entidades.add(new Usuario(101));