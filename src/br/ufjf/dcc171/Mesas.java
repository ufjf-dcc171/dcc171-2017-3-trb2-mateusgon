package br.ufjf.dcc171;

import java.util.List;

public class Mesas {
    private String nome;
    private List <Pedidos> pedidos;

    public Mesas() {
    }

    public Mesas(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return this.nome; //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
