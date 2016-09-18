package br.inatel.lojaonline.models;

/**
 * Created by bccre on 22/06/2016.
 */
public class Product {
    public int Id;
    public String nome;
    public double preco;


    public int getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
