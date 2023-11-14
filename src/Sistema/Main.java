package Sistema;

import java.util.Scanner;

import br.Enum.Categoria;
import br.Models.Clientes;
import br.Models.Vendedores;

public class Main {
    public static void main(String[] args) {
        //CRIAÇÃO DOS OBJETOS
        Vendedores vendedor = new Vendedores(null, null, null, null, null);
        Clientes matheus = new Clientes(null, null, null, null, null);
        Categoria masculino = Categoria.MASCULINO;
        Categoria feminino = Categoria.FEMININO;
        Categoria infantil = Categoria.INFANTIL;

        //IMPORTS
        Scanner sc = new Scanner(System.in);

        //CRIAÇÃO 
        System.out.println("Digite o nome do vendedor: ");
        
    }
} 
