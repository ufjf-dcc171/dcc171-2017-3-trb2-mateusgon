package br.ufjf.dcc171;

public class Pedidos {

    private String nome;
    private String item[];
    private double valorItem[];
    private boolean status;
    private double valor;

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
    
    public double getValorItemPosicao(int i)
    {
        return valorItem[i];
    }

    public void setValorItem(double[] valorItem) {
        this.valorItem = valorItem;
    }
    
    public void setValorItemIndividual (double valorItemIndividual, int posicao)
    {
        valorItem[posicao] = valorItemIndividual;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor + this.valor;
    }
    
}
