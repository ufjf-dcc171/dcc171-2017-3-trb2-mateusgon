package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ItemListModel implements ListModel<Item> {

    private final List<Item> item;
    private final List<ListDataListener> dataListeners;
    
    public ItemListModel(List<Item> item) {
        this.item = item;
        this.dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return item.size();
    }

    @Override
    public Item getElementAt(int index) {
        return item.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
