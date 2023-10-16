package CriarApagarArquivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nome do arquivo onde os dados serão armazenados
        String nomeArquivo = "dados.txt";

        // Verifique se o arquivo já existe
        File arquivo = new File(nomeArquivo);

        // Se o arquivo existe, carregue os dados dele
        if (arquivo.exists()) {
            try {
                Scanner arquivoScanner = new Scanner(arquivo);
                while (arquivoScanner.hasNextLine()) {
                    String linha = arquivoScanner.nextLine();
                    System.out.println("Dado lido do arquivo: " + linha);
                }
                arquivoScanner.close();
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }

        // Peça ao usuário para inserir dados
        System.out.print("Digite uma informação: ");
        String informacao = scanner.nextLine();

        // Salve a informação no arquivo
        try {
            FileWriter writer = new FileWriter(nomeArquivo, true);
            writer.write(informacao + "\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        System.out.println("Informação salva com sucesso.");

        // Encerre o scanner
        scanner.close();
    }
}
