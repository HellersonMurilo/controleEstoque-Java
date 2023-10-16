package CriarApagarArquivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Apagar {
    public static void main(String[] args) {
        // Nome do arquivo que você deseja apagar
        String nomeArquivo = "dados.txt";

        // Verifique se o arquivo existe
        File arquivo = new File(nomeArquivo);

        if (arquivo.exists()) {
            try {
                // Abra o arquivo no modo de sobrescrita (para criar um novo arquivo vazio)
                FileWriter writer = new FileWriter(nomeArquivo, false);
                writer.close();
                System.out.println("Conteúdo do arquivo apagado com sucesso.");
            } catch (IOException e) {
                System.err.println("Erro ao apagar o conteúdo do arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("O arquivo não existe ou já está vazio.");
        }
    }
}
