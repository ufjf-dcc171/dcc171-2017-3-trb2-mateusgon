package br.ufjf.dcc171;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemDoPedidoDAO {

    public void adicionar (BufferedWriter conexao, List<ItemDoPedido> idp) throws IOException
    {
        for (ItemDoPedido i : idp)
        {
            conexao.write(i.getItem().getNome()+"//"
                    +i.getItem().getTipoItem()+
                    "//"+i.getItem().getValor()+"//"+i.getQuantidade()+"//");
            conexao.newLine();
        }
    }
    
    public List buscar (Scanner input, Integer qtddItemDoPedido)
    {
        ArrayList<ItemDoPedido> idp = new ArrayList<>();
        for (int i = 0; i < qtddItemDoPedido; i++)
        {
            Item item = new Item(input.next(), input.next(), input.nextDouble());
            ItemDoPedido itemDoPedido = new ItemDoPedido(item, input.nextInt());
            idp.add(itemDoPedido);
        }
        return idp;
    }
}
