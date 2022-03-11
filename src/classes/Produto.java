package classes;

import java.util.ArrayList;

public class Produto {

    static public ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    private String modelo, descricao , marca , nome;
    private double valor;
    private int codigo, quantidade;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto(String modelo, String descricao, String marca, String nome, double valor, int codigo, int quantidade) {
        this.modelo = modelo;
        this.descricao = descricao;
        this.marca = marca;
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome +
                "\nModelo: " + modelo +
                "\nDescricao: " + descricao +
                "\nMarca: " + marca +
                "\nValor: " + valor +
                "\nCodigo: " + codigo +
                "\nQuantidade no estoque: " + quantidade + "\n";
    }

    public String mostrarTodos() {
        String texto = "";
        for(int i = 0; i < listaProdutos.size(); i++){
            texto += "\n" +listaProdutos.get(i).toString();
        }

        return texto;
    }


    public boolean verProduto(int numero) {
        boolean checar = false;

        for(int i = 0; i < listaProdutos.size(); i++){
           if(listaProdutos.get(i).getCodigo() == numero){
               checar = true;
               break;
           }
        }

        return checar;
    }

    public void vender(int numero, int quantidade) {

        for(int i = 0; i < listaProdutos.size(); i++){
            if(listaProdutos.get(i).getCodigo() == numero){
                listaProdutos.get(i).setQuantidade( listaProdutos.get(i).getQuantidade() - quantidade);
            }
        }
    }
}
