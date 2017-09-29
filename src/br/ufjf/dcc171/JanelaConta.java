package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JanelaConta extends JFrame{

    private final JPanel painel = new JPanel();
    private final JLabel [] labels;
    private Integer i = 0;
    
    public JanelaConta(Pedido pedido) {
        super("Conta");
        setMinimumSize(new Dimension(534, 400));
        labels = new JLabel[(pedido.getItemDoPedido().size() * 3) + 3];
        Box vertical = Box.createVerticalBox();
        labels[i] = new JLabel("Aberto em: " + pedido.getAberto());
        vertical.add(labels[i]);
        i++;
        List<ItemDoPedido> idp;
        idp = pedido.getItemDoPedido();
        for (ItemDoPedido item : idp)
        {
            labels[i] = new JLabel(item.getItem().getNome());
            vertical.add(labels[i]);
            i++;
            labels[i] = new JLabel("Quantidade: " + item.getQuantidade());
            vertical.add(labels[i]);
            i++;
            labels[i] = new JLabel("O valor individual é: R$" + item.getItem().getValor());
            vertical.add(labels[i]);
            i++;
        }

        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        pedido.setFechado(data);
        pedido.setStatusAberto(false);
        labels[i] = new JLabel("Fechado em: " + pedido.getFechado());
        vertical.add(labels[i]);
        i++;
        labels[i] = new JLabel("O valor total foi de R$:" + pedido.getValor());
        vertical.add(labels[i]);
        painel.add(vertical);
        add(new JScrollPane(painel));
    }
}
