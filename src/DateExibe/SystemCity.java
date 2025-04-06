package DateExibe;

import Dominios.AçogueiroCity;
import Dominios.BombeiroCity;
import Dominios.PessoaCity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemCity {

    private final List<PessoaCity> entidades = new ArrayList<>();
    public final Map<String, PessoaCity> mapaDePessoas = new HashMap<>();
    private final LocalDateTime dataDaTransacao = LocalDateTime.now();

    public void inicializarEntidades() {
        PessoaCity pessoa1 = new AçogueiroCity("JUNIOR", "CAIXA");
        PessoaCity pessoa2 = new BombeiroCity("MARIO", "BANCO DO BRASIL");

        adicionarPessoa(pessoa1);
        adicionarPessoa(pessoa2);
    }

    private void adicionarPessoa(PessoaCity pessoa) {
        entidades.add(pessoa);
        mapaDePessoas.put(pessoa.getIdOfUser(), pessoa);
        InicilizandoArrays.adicionarID(pessoa.getIdOfUser());
    }

    public void exibirEntidades() {
        InicilizandoArrays.exibirIDs();
    }

    public void verificarPessoaPorID(String id) {
        PessoaCity pessoa = mapaDePessoas.get(id);
        if (pessoa != null) {
            System.out.println("Pessoa encontrada:");
            System.out.println(pessoa); // Usa toString()
        } else {
            System.out.println("ID não encontrado.");
        }
    }

    public List<PessoaCity> getEntidades() {
        return entidades;
    }

    public LocalDateTime getDataDaTransacao() {
        return dataDaTransacao;
    }
}
