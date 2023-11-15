package br.Models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Produtos {
    private String nomeProduto;
    private double valorProduto;
    private int quantidadeProduto;

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }


    // MÉTODOS ACESSORES
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    // CADASTRAR PRODUTO
    public void CadastrarProduto() {
        Scanner scanner = new Scanner(System.in);

        // Nome do arquivo onde os dados serão armazenados
        String nomeArquivo = "dados.CSV";

        // Peça ao usuário para inserir dados
        System.out.println("Informe a quantidade do produto:");
        setQuantidadeProduto(scanner.nextInt());

        System.out.print("Digite o nome do produto: ");
        setNomeProduto(scanner.next());

        System.out.print("Digite o preço do produto: ");
        setValorProduto(scanner.nextDouble());
        scanner.nextLine(); // Consumir a quebra de linha após o próximoDouble()

        // Salve a informação no arquivo
        try {
            FileWriter writer = new FileWriter(nomeArquivo, true);
            writer.write(getQuantidadeProduto() + "," + getNomeProduto() + "," + getValorProduto() + ";\n");
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

    // VERIFICAR QUANTIDADE DISPONÍVEL ANTES DE REALIZAR A VENDA
    public boolean verificarQuantidadeDisponivel(String nomeProduto, int quantidadeDesejada) {
        try {
            File arquivo = new File("dados.CSV");
            Scanner arquivoScanner = new Scanner(arquivo);

            while (arquivoScanner.hasNextLine()) {
                String linha = arquivoScanner.nextLine();
                String[] dados = linha.split(",");

                if (dados.length >= 3) {
                    String nome = dados[1];
                    int quantidade = Integer.parseInt(dados[0]);

                    if (nome.equals(nomeProduto) && quantidadeDesejada <= quantidade) {
                        arquivoScanner.close();
                        return true; // Quantidade disponível
                    }
                }
            }

            arquivoScanner.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println("Produto não encontrado ou quantidade insuficiente.");
        return false; // Produto não encontrado ou quantidade indisponível
    }

    // ATUALIZAR O ARQUIVO CSV APÓS A VENDA
    public void atualizarArquivoCSV(String nomeProduto, int quantidadeVendida) {
        try {
            File arquivoAntigo = new File("dados.CSV");
            File arquivoNovo = new File("dados_temp.CSV");

            Scanner arquivoScanner = new Scanner(arquivoAntigo);
            FileWriter writer = new FileWriter(arquivoNovo, true);

            while (arquivoScanner.hasNextLine()) {
                String linha = arquivoScanner.nextLine();
                String[] dados = linha.split(",");

                if (dados.length >= 3) {
                    String nome = dados[1];
                    int quantidade = Integer.parseInt(dados[0]);
                    double valor = Double.parseDouble(dados[2].replace(";", ""));

                    if (nome.equals(nomeProduto)) {
                        quantidade -= quantidadeVendida;
                        if (quantidade < 0) {
                            quantidade = 0; // Evitar quantidade negativa
                        }
                    }

                    writer.write(quantidade + "," + nome + "," + valor + ";\n");
                }
            }

            arquivoScanner.close();
            writer.close();

            // Renomeia o arquivo temporário para substituir o original
            if (arquivoAntigo.delete() && arquivoNovo.renameTo(new File("dados.CSV"))) {
                System.out.println("Venda realizada com sucesso. Estoque atualizado.");
            } else {
                System.err.println("Erro ao atualizar o arquivo após a venda.");
            }

        } catch (IOException e) {
            System.err.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }

    // REALIZAR VENDA
    public void RealizarVenda(String nomeProduto, String nomeCliente, int quantidadeDesejada) {
        if (verificarQuantidadeDisponivel(nomeProduto, quantidadeDesejada)) {
            setNomeProduto(nomeProduto);
            setQuantidadeProduto(quantidadeDesejada);
            atualizarArquivoCSV(nomeProduto, quantidadeDesejada);
        }
    }

}
