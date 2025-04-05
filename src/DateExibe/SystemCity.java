package DateExibe;

import Dominios.AçogueiroCity;
import Dominios.PessoaCity;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemCity {
        public ArrayList<PessoaCity> entidades = new ArrayList<>();
        public HashMap<String, PessoaCity> mapaDePessoas = new HashMap<>();

        public void inicializarEntidades() {
            PessoaCity pessoa1 = new AçogueiroCity("JUNIOR", "CAIXA");

            entidades.add(pessoa1);
            mapaDePessoas.put(pessoa1.getIdOfUser(), pessoa1); // Relacionando ID com pessoa

            InicilizandoArrays.adicionarID(pessoa1.getIdOfUser());
        }

        public void exibirEntidades() {
            InicilizandoArrays.exibirIDs();
        }

        // Aqui está a parte que você queria: a condicional usando o ID
        public void verificarPessoaPorID(String id) {
            if (mapaDePessoas.containsKey(id)) {
                PessoaCity encontrada = mapaDePessoas.get(id);
                System.out.println("Pessoa encontrada:");
                System.out.println(encontrada); // Chama o toString()
            } else {
                System.out.println("ID não encontrado.");
            }
        }

        public ArrayList<PessoaCity> getEntidades() {
            return entidades;
        }
    }