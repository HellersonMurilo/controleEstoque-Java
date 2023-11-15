package Sistema;

import java.io.File;
import java.util.Scanner;
import br.Models.Clientes;
import br.Models.Produtos;
import br.Models.Vendedores;

public class Main {
    public static void main(String[] args) {
        // CRIAÇÃO DOS OBJETOS
        Vendedores vendedor = new Vendedores(null, null, null, null, null);
        Clientes clientes = new Clientes(null, null, null, null, null);
        Produtos produtos = new Produtos();

        // IMPORTS
        Scanner sc = new Scanner(System.in);

        boolean loopControleMenu = false;
        while (!loopControleMenu) {
            // MENU
            System.out.println("MENU DE OPÇÕES\n1 - Vendedores\n2 - Gerar Relatorio\n3 - Encerrar");
            int opcaoSelecionada = sc.nextInt();

            // SWITCH
            switch (opcaoSelecionada) {
                case 1: // Vendedores
                    System.out.println("==========");
                    System.out.println("VENDEDORES\n1 - Cadastrar Vendedores\n2 - Realizar Venda\n3 - Produtos");
                    int escolhaVendedores = sc.nextInt();
                    // SWITCH OPÇÃO 1
                    switch (escolhaVendedores) {
                        case 1: // cadastrar vendedores
                            vendedor.CadastroVendedores();
                            break;
                        case 2: // Realizar Venda
                            System.out.println("Digite o nome do produto:");
                            String nomeProdutoVenda = sc.next();
                            System.out.println("Digite o nome do cliente:");
                            String nomeCliente = sc.next();
                            System.out.println("Digite a quantidade desejada:");
                            int quantidadeDesejada = sc.nextInt();
                            produtos.RealizarVenda(nomeProdutoVenda, nomeCliente, quantidadeDesejada);
                            break;
                        case 3: // SWITCH PRODUTOS
                            boolean loop = false;
                            while (!loop) {
                                System.out.println("==========");
                                System.out.println("PRODUTOS\n1 - Cadastrar Produtos\n2 - Ver Produtos\n 3 - voltar");
                                int escolhaProdutos = sc.nextInt();
                                // INICIO SWITCH
                                switch (escolhaProdutos) {
                                    case 1:
                                        produtos.CadastrarProduto();
                                        break;
                                    case 2:
                                        produtos.LerProdutos();
                                        break;
                                    case 3:
                                        System.out.println("voltando...\n");
                                        loop = true;
                                        break;

                                    default:
                                        System.out.println("Numero informado inválido...");
                                        break;
                                }
                            }
                            break;

                        default:
                            System.out.println("Número informado inválido, tente novamente");
                            break;
                    }
                    break;
                case 2: // Gerar Relatório
                    // Validar se o arquivo existe
                    String nomeArquivo = "dados.CSV";
                    File arquivo = new File(nomeArquivo);
                    if (arquivo.exists()) {
                        System.out.println("Relatório Gerado com Sucesso\n");
                    } else {
                        System.out.println("Não há informação, logo o relatório não existe\n");
                    }
                    break;
                case 3:
                    System.out.println("Sistema Encerrado...");
                    loopControleMenu = true;
                    break;
                default:
                    System.out.println("Número informado inválido, tente novamente");
                    break;
            }
        }
    }
}
