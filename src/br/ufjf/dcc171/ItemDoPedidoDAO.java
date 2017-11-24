package br.ufjf.dcc171;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class ItemDoPedidoDAO {

    public void adicionar (BufferedWriter conexao, List<ItemDoPedido> idp) throws IOException
    {
        for (ItemDoPedido i : idp)
        {
            conexao.write(i.getItem().getNome()+"//"
                    +i.getItem().getTipoItem()+
                    "//"+i.getItem().getValor()+"//"+i.getQuantidade()+"//");
        }
    }
    
}
