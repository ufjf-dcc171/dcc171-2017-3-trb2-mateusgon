package br.ufjf.dcc171;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Pizzaria {
    
    private ArrayList<Mesas> mesas = new ArrayList<>();
    private SampleDataItem sdi;    
    private Diretorio dir;
    private MesasDAO mesasDAO = new MesasDAO();
    private ItemDAO itemDAO = new ItemDAO();
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private ItemDoPedidoDAO itemDoPedidoDao = new ItemDoPedidoDAO();
    private Integer contadorDeMesas; 
    private Integer contadorDePedidos=0;
    
    public Pizzaria() throws IOException {
        dir = new Diretorio();
        sdi = new SampleDataItem(itemDAO);
        ler();
        try 
        {
            contadorDeMesas = mesas.get(mesas.size()-1).getNumero() + 1;
            int i = 0;
            int j = 0;
            for (Mesas m : mesas)
            {
                for (j = 0; j < mesas.get(i).getPedidos().size(); j++)
                {    
                    if (mesas.get(i).getPedidos().get(j).getNumero() >= this.contadorDePedidos)
                    {
                        this.contadorDePedidos = mesas.get(i).getPedidos().get(j).getNumero() + 1;     
                    }
                }
                i++;
            }
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            contadorDeMesas = 0;
        }
      }
    
    public void gravar (List<Mesas> m)
    {
        mesasDAO.adicionar(m, pedidoDAO, itemDoPedidoDao);
    }
    public void ler () throws FileNotFoundException
    {
        this.mesas = mesasDAO.buscar(pedidoDAO, itemDoPedidoDao);       
    }

    public void atualizarItem () throws IOException
    {
        sdi.atualiza();
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

    public Diretorio getDir() {
        return dir;
    }

    public void setDir(Diretorio dir) {
        this.dir = dir;
    }

    public MesasDAO getMesasDAO() {
        return mesasDAO;
    }

    public void setMesasDAO(MesasDAO mesasDAO) {
        this.mesasDAO = mesasDAO;
    }

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public ItemDoPedidoDAO getItemDoPedidoDao() {
        return itemDoPedidoDao;
    }

    public void setItemDoPedidoDao(ItemDoPedidoDAO itemDoPedidoDao) {
        this.itemDoPedidoDao = itemDoPedidoDao;
    }

    public Integer getContadorDeMesas() {
        return contadorDeMesas;
    }

    public void setContadorDeMesas(Integer contadorDeMesas) {
        this.contadorDeMesas = contadorDeMesas;
    }

    public void aumentarContadorDeMesas() {
        this.contadorDeMesas = this.contadorDeMesas + 1;
    }

    public Integer getContadorDePedidos() {
        return contadorDePedidos;
    }

    public void setContadorDePedidos(Integer contadorDePedidos) {
        this.contadorDePedidos = contadorDePedidos;
    }
    
    public void aumentarContadorDePedidos ()
    {
        this.contadorDePedidos = this.contadorDePedidos + 1;
    }
}
