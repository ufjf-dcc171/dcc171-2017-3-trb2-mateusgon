package br.ufjf.dcc171;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PedidoDAO {


    public void adicionar (List<Pedido> ped, BufferedWriter conexao, ItemDoPedidoDAO idp) throws IOException
    {
        for (Pedido p : ped)
        {
            conexao.write(p.getNome()+"//"+p.getNumero()+"//"+p.isStatusAberto()+"//"+p.getAberto()+"//"+p.getFechado()+"//"+p.getValor()+"//"+p.getItemDoPedido().size()+"//");
            conexao.newLine();
            List<ItemDoPedido> itemDoPedido = p.getItemDoPedido();
            idp.adicionar(conexao, itemDoPedido);
        }     
    }
    
    public List buscar (ItemDoPedidoDAO idp, Scanner input, Integer qtddPedidos)
    {
        ArrayList<Pedido> p = new ArrayList<>();
        for (int i = 0; i < qtddPedidos; i++)
        {
           input.useLocale(Locale.ENGLISH);
           Pedido ped = new Pedido(input.next(), input.nextInt(), input.nextBoolean(), input.next(), input.next(), input.nextDouble());   
           ped.setItemDoPedido(idp.buscar(input, input.nextInt()));
           p.add(ped);
        }
        return p;
    }
}
