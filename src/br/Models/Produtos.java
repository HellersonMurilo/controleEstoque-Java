package br.Models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Produtos {
    private String nomeProduto;
    private String valorProduto;

    // MÉTODOS ACESSORES
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(String valorProduto) {
        this.valorProduto = valorProduto;
    }

    // CADASTRAR PRODUTO
    public void CadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        // Nome do arquivo onde os dados serão armazenados
        String nomeArquivo = "dados.CSV";

        // Peça ao usuário para inserir dados
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha após o próximoDouble()

        // Salve a informação no arquivo
        try {
            FileWriter writer = new FileWriter(nomeArquivo, true);
            writer.write(nome + "," + preco + ";\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        System.out.println("Informação salva com sucesso.");
    }

    // LER ARQUIVO
    public void LerProdutos() {
        // Nome do arquivo onde os dados serão armazenados
        String nomeArquivo = "dados.CSV";

        // Verifique se o arquivo já existe
        File arquivo = new File(nomeArquivo);

        // Se o arquivo existe, carregue os dados dele
        if (arquivo.exists()) {
            try {
                Scanner arquivoScanner = new Scanner(arquivo);
                System.out.println("========== DADOS CSV ==========");
                while (arquivoScanner.hasNextLine()) {
                    String linha = arquivoScanner.nextLine();
                    System.out.println(linha);
                }
                arquivoScanner.close();
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }
    }
}
