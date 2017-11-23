package br.ufjf.dcc171;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Pizzaria {
    
    private ArrayList<Mesas> mesas = new ArrayList<>();
    private ArrayList<Pedido> pedido = new ArrayList<>();
    private ArrayList<ItemDoPedido> itemDoPedido = new ArrayList<>();
    private SampleDataItem sdi;    
    private Diretorio dir;
    private MesasDAO mesasDAO = new MesasDAO();
    private ItemDAO itemDAO = new ItemDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();
    
    
    public Pizzaria(SampleDataItem sdi, Diretorio dir) {
        this.sdi = sdi;
        this.dir = dir;
    }
    
    public Pizzaria() throws IOException {
        dir = new Diretorio();
        sdi = new SampleDataItem();
    }
    
    public void gravar (List<Mesas> m)
    {
        mesasDAO.adicionar(m);
    }
    public void ler ()
    {
        
    }

    public SampleDataItem getSdi() {
        return sdi;
    }

    public void setSdi(SampleDataItem sdi) {
        this.sdi = sdi;
    }

    public List<Mesas> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesas> mesas) {
        this.mesas = mesas;
    }

    public ArrayList<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Pedido> pedido) {
        this.pedido = pedido;
    }

    public ArrayList<ItemDoPedido> getItemDoPedido() {
        return itemDoPedido;
    }

    public void setItemDoPedido(ArrayList<ItemDoPedido> itemDoPedido) {
        this.itemDoPedido = itemDoPedido;
    }

    public Diretorio getDir() {
        return dir;
    }

    public void setDir(Diretorio dir) {
        this.dir = dir;
    }
}
