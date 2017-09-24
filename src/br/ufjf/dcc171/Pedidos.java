package br.ufjf.dcc171;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pedidos {

    private String nome;
    private String item[];
    private double valorItem[];
    private int itemSelecionado[];
    private boolean status;
    private double valor;
    private Date aberto;
    private Date fechado;

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
        return this.nome + " - " + "R$" + this.valor + " - " + this.getAberto();
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

    public int getItemSelecionado(int i) {
        return itemSelecionado[i];
    }

    public void setItemSelecionado(int[] itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public String getAberto() {
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        return dtHora.format(aberto);
    }

    public void setAberto(Date aberto) {
        this.aberto = aberto;
    }

    public String getFechado() {
        DateFormat dtHora = DateFormat.getDateTimeInstance();
        return dtHora.format(fechado);
    }

    public void setFechado(Date fechado) {
        this.fechado = fechado;
    }

    public String getNome() {
        return nome;
    }
    
    
    
}
