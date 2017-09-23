package br.ufjf.dcc171;

public class Pedidos {

    private String nome;
    private  String item[];
    private  double valorItem[];
    private  boolean status;

    public Pedidos(String nome, String[] item, double[] valorItem, boolean status) {
        this.item = item;
        this.valorItem = valorItem;
        this.status = status;
    }

    public Pedidos(String nome) {
        this.nome = nome;
    }

    public Pedidos() {
        
    }

    public String[] getItem() {
        return item;
    }

    public void setItem(String[] item) {
        this.item = item;
    }

    public double[] getValorItem() {
        return valorItem;
    }

    public void setValorItem(double[] valorItem) {
        this.valorItem = valorItem;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
