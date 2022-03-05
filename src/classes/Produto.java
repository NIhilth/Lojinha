package classes;

import java.util.ArrayList;

public class Produto {

    static public ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    private String modelo, descricao , marca , nome;
    private double valor;
    private int codigo, quantidade;

    private static void reduzirEstoque(){

    }

    public static ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public static void setListaProdutos(ArrayList<Produto> listaProdutos) {
        Produto.listaProdutos = listaProdutos;
    }

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
}
