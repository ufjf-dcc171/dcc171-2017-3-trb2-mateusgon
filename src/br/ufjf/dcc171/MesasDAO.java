package br.ufjf.dcc171;

import java.util.ArrayList;

public class MesasDAO {

    private String endereco;
    
    public MesasDAO(String enderecoMesas) {
        endereco = enderecoMesas;
    }

    public void criar ()
    {
    
    }

    public void adicionar ()
    {
    
    }

    public ArrayList<Mesas> buscar ()
    {
        ArrayList <Mesas> m = new ArrayList<>();
        Mesas a = new Mesas("Mesa 0", 0);
        m.add(a);
        return m;
    }

    public void excluir ()
    {
    
    }
    
}
