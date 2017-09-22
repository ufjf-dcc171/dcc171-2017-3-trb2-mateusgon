package br.ufjf.dcc171;

import java.util.List;

public class Mesas {
    private String nome;
    private List <Pedidos> pedidos;

    public Mesas() {
    }

    public Mesas(String nome, List<Pedidos> pedidos) {
        this.nome = nome;
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List <Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List <Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    
    
}
