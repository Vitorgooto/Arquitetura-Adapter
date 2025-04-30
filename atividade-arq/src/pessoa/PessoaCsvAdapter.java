package pessoa;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PessoaCsvAdapter implements RepositorioPessoas {

    private final String arquivoCsv;

    public PessoaCsvAdapter(String arquivoCsv) {
        this.arquivoCsv = arquivoCsv;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(arquivoCsv)) {
            if (is == null) {
                throw new FileNotFoundException("Arquivo não encontrado: " + arquivoCsv);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String linha;
            br.readLine(); // Pular cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    String nome = partes[0].trim();
                    int idade = Integer.parseInt(partes[1].trim());
                    String email = partes[2].trim();
                    pessoas.add(new Pessoa(nome, idade, email));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return pessoas;
    }
}
