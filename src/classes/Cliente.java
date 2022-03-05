package classes;

import java.util.ArrayList;

public class Cliente extends Pessoa{

    static public ArrayList<Cliente> listaCLientes = new ArrayList<Cliente>();
    private int numeroCadastro;

    public int getNumeroCadastro() {
        return numeroCadastro;
    }

    public void setNumeroCadastro(int numeroCadastro) {
        this.numeroCadastro = numeroCadastro;
    }

    public Cliente(String pais, String estado, String cidade, String bairro, String rua, String complemento, int numero, int cep, String nome, String cpf, String email, String telefone, String genero, int idade, int numeroCadastro) {
        super(pais, estado, cidade, bairro, rua, complemento, numero, cep, nome, cpf, email, telefone, genero, idade);
        this.numeroCadastro = numeroCadastro;
    }
}
