package Sistema;

import java.util.Scanner;
import br.Models.Clientes;
import br.Models.Produtos;
import br.Models.Vendedores;

public class Main {
    public static void main(String[] args) {
        // CRIAÇÃO DOS OBJETOS
        Vendedores vendedor = new Vendedores(null, null, null, null, null);
        Clientes matheus = new Clientes(null, null, null, null, null);
        Produtos produtos = new Produtos();

        // IMPORTS
        Scanner sc = new Scanner(System.in);

        // MENU
        System.out.println("MENU DE OPÇÕES\n1 - Vendedores\n2 - Venda\n3 - Gerar Relatório");
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

                        break;
                    case 3: // SWITCH PRODUTOS
                        boolean loop = false;
                        while (loop == false) {
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
                                    System.out.println("voltando...");
                                    loop = true;
                                    break;

                                default:
                                    break;
                            }
                        }
                        break;

                    default:
                        System.out.println("Número informado inválido, tente novamente");
                        break;
                }
                break;
            case 2: // Realizar venda

                break;
            case 3: // Gerar Relatório

                break;
            default:
                System.out.println("Número informado inválido, tente novamente");
                break;
        }

    }
}
