package classes;

import java.util.ArrayList;

public class Funcionario extends Pessoa{

    static public ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
    private int matricula;
    private String senha ;
    private static void vender(){

    }

    public static ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        Funcionario.listaFuncionarios = listaFuncionarios;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean checarFuncionario(int numero, String senha) {
        boolean verifica = false;

        for(int i = 0; i < Funcionario.listaFuncionarios.size(); i++){
            if(Funcionario.listaFuncionarios.get(i).getMatricula() == numero && Funcionario.listaFuncionarios.get(i).getSenha().equals(senha) ){
                verifica = true;
            }
        }

        return verifica;
    }

    public Funcionario(String pais, String estado, String cidade, String bairro, String rua, String complemento, int numero, int cep, String nome, String cpf, String email, String telefone, String genero, int idade, int matricula, String senha) {
        super(pais, estado, cidade, bairro, rua, complemento, numero, cep, nome, cpf, email, telefone, genero, idade);
        this.matricula = matricula;
        this.senha = senha;
    }
}
