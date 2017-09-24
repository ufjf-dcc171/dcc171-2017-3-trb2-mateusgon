package br.ufjf.dcc171;

public class SampleDataPedidos {

    private final Pedidos p1;
    private String nome;
    private final String itemNome[] = {"Pepperoni (Pepperoni e Manjericão)", "Champignon (Champignon e Azeitona Preta)", "Pizza Ao Alho (Alho torrado e azeite)",
    "Portuguesa (Presunto, ovo, cebola e azeitona preta)", "Frango c/ Requeijão (Peito de frango, azeitona preta e requeijão)", "4 queijos (Provolone, requeijão, parmesão e mussarela)", "Napolitana (Parmesão e muito mais rodelas de tomate)", "Palmito (Presunto, palmito, azeitona preta e manjericão)",
    "Banana com Canela (Mussarela, Banana, açúcar, canela)", "Brigadeiro (Mussarela, chocolate e granulado de chocolate)", "Roma (Mussarela, banana, açúcar, canela e chocolate)", "Bibiena (Massa de chocolate, chocolate, mini-confetes)", "Sorvete Napolitano", "Petit Gateau e Sorvete Napolitano",
    "Banana Split", "Milk Shake", "Refrigerante 500ml", "Refrigerante 1,5lts", "Suco Copo", "Cerveja Long Neck"};
    private final double valorItem[] = {42.9, 40.9, 40.9, 41.9, 42.9, 43.9, 41.9, 42.9, 40.9, 41.9, 43.9, 44.9, 
    5.0, 13.0, 10.0, 9.0, 6.0, 10.0, 5.0, 7.0};
    private final boolean statusDoPedidoAberto = true;
    
    public SampleDataPedidos() {
        p1 = new Pedidos();
        this.p1.setItem(itemNome);
        this.p1.setValorItem(valorItem);
        this.p1.setStatus(statusDoPedidoAberto);
    }
      
    public Pedidos getPedido ()
    {
        return p1;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(int posicao) {
        return posicao + " - " + itemNome[posicao] + " - R$" + valorItem[posicao];
    }

    
}
    
    

