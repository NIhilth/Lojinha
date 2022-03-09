package classes;

import java.util.ArrayList;

public class Gerente extends Funcionario{

    static public ArrayList<Gerente> listaGerentes = new ArrayList<Gerente>();

    public Gerente(String pais, String estado, String cidade, String bairro, String rua, String complemento, int numero, int cep, String nome, String cpf, String email, String telefone, String genero, int idade, int matricula, String senha) {
        super(pais, estado, cidade, bairro, rua, complemento, numero, cep, nome, cpf, email, telefone, genero, idade, matricula, senha);
    }
}
