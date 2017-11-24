package br.ufjf.dcc171;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class PedidoDAO {


    public void adicionar (List<Pedido> ped, BufferedWriter conexao, ItemDoPedidoDAO idp) throws IOException
    {
        for (Pedido p : ped)
        {
            conexao.write(p.getNome()+"//"+p.isStatusAberto()+"//"+p.getAberto()+"//"+p.getFechado()+"//"+p.getValor()+"//");
            List<ItemDoPedido> itemDoPedido = p.getItemDoPedido();
            idp.adicionar(conexao, itemDoPedido);
        }     
    }
    
}
