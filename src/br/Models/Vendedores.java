package br.Models;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendedores extends Cadastro {

    // atributos
    private String cpf;
    private String rg;

    // métodos acessores
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    // construtor
    public Vendedores(String nome, String email, String endereco, String cpf, String rg) {
        super(nome, email, endereco);
        this.rg = rg;
        this.cpf = cpf;
    }

    // MÉTODO

    // lista para armazenar os vendedores
    private static ArrayList<Vendedores> listaVendedores = new ArrayList<>();

    // Cadastro de Vendedores
    public void CadastroVendedores() {
        // importando o leitor
        Scanner sc = new Scanner(System.in);

        // input dos vendedores
        System.out.println("Informe o nome do vendedor");
        setNome(sc.next());
        System.out.println("Informe o CPF do vendedor");
        setCpf(sc.next());
        System.out.println("Informe o RG do vendedor");
        setRg(sc.next());
        System.out.println("Informe o Email do vendedor");
        setEmail(sc.next());
        System.out.println("Informe o Endereço do vendedor");
        setEndereco(sc.next());

        // Adiciona o vendedor à lista
        listaVendedores.add(new Vendedores(getNome(), getEmail(), getEndereco(), getCpf(), getRg()));

        System.out.println("Deseja ver os Dados? Y/n");
        String escolha = sc.next();
        if (escolha.equalsIgnoreCase("y")) {
            for (Vendedores vendedor : listaVendedores) {
                System.out.println("Nome: " + vendedor.getNome());
                System.out.println("CPF: " + vendedor.getCpf());
                System.out.println("RG: " + vendedor.getRg());
                System.out.println("Email: " + vendedor.getEmail());
                System.out.println("Endereço: " + vendedor.getEndereco());
                System.out.println("============");
            }
        } else {
            System.out.println("Vendedor cadastrado com sucesso");
        }
    }

    // Método para acessar a lista de vendedores
    public static ArrayList<Vendedores> getListaVendedores() {
        return listaVendedores;
    }

}
