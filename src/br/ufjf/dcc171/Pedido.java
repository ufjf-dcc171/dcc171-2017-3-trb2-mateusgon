package br.ufjf.dcc171;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Pedido {

    private String nome;
    private List<ItemDoPedido> itemDoPedido;
    private boolean statusAberto;
    private Date aberto;
    private Date fechado;
    private Double valor;

    public Pedido(String nome) {
        this.nome = nome;
    }

    public Pedido ()
    {
        itemDoPedido = new ArrayList<ItemDoPedido>();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemDoPedido> getItemDoPedido() {
        return itemDoPedido;
    }

    public void setItemDoPedido(List<ItemDoPedido> itemDoPedido) {
        this.itemDoPedido = itemDoPedido;
    }

    public boolean isStatusAberto() {
        return statusAberto;
    }

    public void setStatusAberto(boolean statusAberto) {
        this.statusAberto = statusAberto;
    }

    public Date getAberto() {
        return aberto;
    }

    public void setAberto(Date aberto) {
        this.aberto = aberto;
    }

    public Date getFechado() {
        return fechado;
    }

    public void setFechado(Date fechado) {
        this.fechado = fechado;
    }

    public Double getValor() {
        Double valor = 0.0;
        for (ItemDoPedido idp : itemDoPedido)
        {
            valor = valor + idp.getItem().getValor() * idp.getQuantidade();
        }
        this.valor = valor;
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
