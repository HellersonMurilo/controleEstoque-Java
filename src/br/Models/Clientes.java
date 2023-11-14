package br.Models;

public class Clientes extends Cadastro {
    // atributos
    private String cpfCnpj;
    private String telefone;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //construtor
    public Clientes(String nome, String email, String endereco, String cpfCnpj, String telefone) {
        super(nome, email, endereco);
        this.telefone = telefone;
        this.cpfCnpj = cpfCnpj;
    }

}
