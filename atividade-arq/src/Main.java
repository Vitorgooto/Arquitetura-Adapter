import pessoa.Pessoa;
import pessoa.PessoaCsvAdapter;
import pessoa.RepositorioPessoas;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioPessoas repositorio = new PessoaCsvAdapter("Pessoas.csv");
        List<Pessoa> pessoas = repositorio.listarPessoas();

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
