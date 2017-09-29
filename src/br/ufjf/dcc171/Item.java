package br.ufjf.dcc171;

public class Item {

    private String nome;
    private String tipoItem;
    private Double valor;
    

    public Item() {
    }

    public Item(String nome, String tipoItem, Double valor) {
        this.nome = nome;
        this.tipoItem = tipoItem;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nome + " - R$" + valor;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
    
}
    
    

