package br.ufjf.dcc171;

import java.io.FileWriter;
import java.util.ArrayList;

public class SampleDataItem {
    private ArrayList<Item> item;
    private String endereco;

    public SampleDataItem(FileWriter itens) {
        item = new ArrayList<Item>();
        endereco = itens.toString();
        adicionaItem(item);
    }

    private void adicionaItem(ArrayList<Item> itemList) {
        Item item[] = new Item[20];
        item[0] = new Item("Pepperoni (Pepperoni e Manjericão)", "Pizza Salgada", 42.90);
        item[1] = new Item("Champignon (Champignon e Azeitona Preta)", "Pizza Salgada", 40.90);
        item[2] = new Item("Pizza Ao Alho (Alho torrado e azeite)", "Pizza Salgada", 40.90);
        item[3] = new Item("Portuguesa (Presunto, ovo, cebola e azeitona preta)", "Pizza Salgada", 41.90);
        item[4] = new Item("Frango c/ Requeijão (Peito de frango, azeitona preta e requeijão)", "Pizza Salgada", 42.90);
        item[5] = new Item("4 queijos (Provolone, requeijão, parmesão e mussarela)", "Pizza Salgada", 43.90);
        item[6] = new Item("Napolitana (Parmesão e muito mais rodelas de tomate)", "Pizza Salgada", 41.90);
        item[7] = new Item("Palmito (Presunto, palmito, azeitona preta e manjericão)", "Pizza Salgada", 42.90);
        item[8] = new Item("Banana com Canela (Mussarela, Banana, açúcar, canela)", "Pizza Doce", 40.90);
        item[9] = new Item("Brigadeiro (Mussarela, chocolate e granulado de chocolate)", "Pizza Doce", 41.90);
        item[10] = new Item("Roma (Mussarela, banana, açúcar, canela e chocolate)", "Pizza Doce", 43.90);
        item[11] = new Item("Bibiena (Massa de chocolate, chocolate, mini-confetes)", "Pizza Doce", 43.90);
        item[12] = new Item("Sorve Napolitano", "Sobremesa", 5.00);
        item[13] = new Item("Petit Gateau e Sorvete Napolitano", "Sobremesa", 13.00);
        item[14] = new Item("Banana Split", "Sobremesa", 10.00);
        item[15] = new Item("Milk Shake", "Sobremesa", 9.00);
        item[16] = new Item("Refrigerante 600ml", "Bebida", 6.00);
        item[17] = new Item("Refrigerante 1,5lts", "Bebida", 10.00);
        item[18] = new Item("Suco Copo 500ml", "Bebida", 5.00);
        item[19] = new Item("Cerveja Long Neck", "Bebida", 7.00);
        for (int i = 0; i < 20; i++)
        {
            itemList.add(item[i]);
        }
    }
    
    public ArrayList<Item> getItem() {
        return item;
    }
    
    public String getTipo (int i)
    {
        Item f = item.get(i);        
        return f.getTipoItem();
    }
    
    public String nomeValor (int i)
    {
        Item f = item.get(i);
        String resultado = String.format("%.2f", f.getValor());
        return f.getNome() + " - R$" + resultado;
    }
    
    public Item getItemPosicao(int i)
    {
        Item f = item.get(i);
        return f;
    }
    
    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }
    
    
}
