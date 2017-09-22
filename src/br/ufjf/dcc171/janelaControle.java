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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class janelaControle extends JFrame {
        
        //private final List<Mesas> mesas;
        private final JList<Mesas> lstMesas = new JList<>(new DefaultListModel<>());
        private final JList<Pedidos> lstPedidos = new JList<>(new DefaultListModel<>());
        private final JButton adicionarMesa = new JButton("Adicionar Mesa");
        private final JButton excluirMesa = new JButton("Excluir Mesa");
        private final JButton realizarPedido = new JButton("Realizar Pedido");
        private final JButton fecharConta = new JButton("Fechar Conta");
        
    
    public janelaControle() throws HeadlessException {
        super("Controle de Pedidos");
        setMinimumSize(new Dimension(300, 300));
        
        JPanel botoes = new JPanel(new GridLayout(2, 2));
        botoes.add(adicionarMesa);
        botoes.add(realizarPedido);
        botoes.add(excluirMesa);
        botoes.add(fecharConta);
        
        add(new JScrollPane(lstMesas), BorderLayout.WEST);
        add(new JScrollPane(lstPedidos), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);  
        
        realizarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPedidos pedidos = new janelaPedidos();
                pedidos.setSize(534, 400);
                pedidos.setLocationRelativeTo(null);
                pedidos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pedidos.setVisible(true);    
            }
        });
    }    
}
