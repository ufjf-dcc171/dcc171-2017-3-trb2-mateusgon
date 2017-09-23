package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class janelaControle extends JFrame {
        
        private int i;
        private final List<Mesas> mesas;
        private final JList<Mesas> lstMesas = new JList<>(new DefaultListModel<>());
        private final JList<Pedidos> lstPedidos = new JList<>(new DefaultListModel<>());
        private final JButton adicionarMesa = new JButton("Adicionar Mesa");
        private final JButton excluirMesa = new JButton("Excluir Mesa");
        private final JButton realizarPedido = new JButton("Realizar Pedido");
        private final JButton fecharConta = new JButton("Fechar Conta");
        private final JButton verCardapio = new JButton("Ver Cardapio");
        private final JButton excluirPedido = new JButton("Excluir Pedido");
    
    public janelaControle(List<Mesas> sampleData) throws HeadlessException {
        super("Controle de Pedidos");
        setMinimumSize(new Dimension(534, 400));
        
        this.mesas = sampleData;
        lstMesas.setModel(new MesasListModel(mesas));
        
        
        JPanel botoes = new JPanel(new GridLayout(2, 4));
        botoes.add(adicionarMesa);
        botoes.add(realizarPedido);
        botoes.add(verCardapio);
        botoes.add(excluirMesa);
        botoes.add(excluirPedido);
        botoes.add(fecharConta);
        
        add(new JScrollPane(lstMesas), BorderLayout.WEST);
        add(new JScrollPane(lstPedidos), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);  
        
        lstMesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        realizarPedido.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Mesas selecionado = lstMesas.getSelectedValue();
                   if (selecionado != null)
                   {
                       janelaPedidos pedidos = new janelaPedidos();
                       pedidos.setSize(534, 400);
                       pedidos.setLocationRelativeTo(null);
                       pedidos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                       pedidos.setVisible(true);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
                
        adicionarMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
               i++;
               Mesas m = new Mesas("Mesa " + i);
               mesas.add(m);
               lstMesas.updateUI();
               pack();
            }
        });
        
        excluirMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mesas selecionado = lstMesas.getSelectedValue();
                   if (selecionado != null)
                   {
                       mesas.remove(lstMesas.getSelectedValue());
                       lstMesas.clearSelection();
                       lstMesas.updateUI();
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
                   }
            }
        });
        
        fecharConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }    
}
