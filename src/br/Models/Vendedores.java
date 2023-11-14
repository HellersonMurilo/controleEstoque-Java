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

    // Cadastro de Vendedores
    public void CadastroVendedores() {
        // importando o leitor
        Scanner sc = new Scanner(System.in);

        // lista para adicionar vendedores
        ArrayList<String> vendedores = new ArrayList<>();

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

        vendedores.add(getNome());
        vendedores.add(getCpf());
        vendedores.add(getRg());
        vendedores.add(getEmail());
        vendedores.add(getEndereco());

        System.out.println("Deseja ver os Dados? Y/n");
        String escolha = sc.next();
        if (escolha == "y".toUpperCase()) {
            for (String i : vendedores) {
                System.out.println(i);
                System.out.println("============");
            }
        }else{
            System.out.println("Fornecedor cadastrado com sucesso");
        }

    }

    public void RealizarVenda(String nomeProduto) {

    }

}
