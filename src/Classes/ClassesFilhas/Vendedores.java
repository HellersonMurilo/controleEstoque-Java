package Classes.ClassesFilhas;

import Classes.Cadastro;

public class Vendedores extends Cadastro {
    
    //atributos
    private String cpf;
    private String rg;

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

    //construtor
    public Vendedores(String nome, String email, String endereco, String cpf, String rg) {
        super(nome, email, endereco);
        this.rg = rg;
        this.cpf = cpf;
    }

    //método
    //criar arquivo para cadastro do Vendedor
    

}
