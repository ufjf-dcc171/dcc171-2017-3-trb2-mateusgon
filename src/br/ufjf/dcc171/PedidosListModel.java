package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class PedidosListModel implements ListModel<Pedidos> {

    private final List<Pedidos> pedidos;
    private final List<ListDataListener> dataListener;

    public PedidosListModel(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
        this.dataListener = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return pedidos.size();
    }

    @Override
    public Pedidos getElementAt(int index) {
        return pedidos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListener.remove(l);
    }
    
}
