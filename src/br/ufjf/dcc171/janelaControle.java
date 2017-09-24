package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
        private int contadorPedidos=0;
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
        setPreferredSize(new Dimension(534, 400));
        
        this.mesas = sampleData;
        lstMesas.setModel(new MesasListModel(mesas));
        
        lstMesas.setPreferredSize(new Dimension(267, 200));
        lstPedidos.setPreferredSize(new Dimension(217, 200));
        
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
        lstMesas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Mesas selecionado = lstMesas.getSelectedValue();
                if (selecionado != null)
                   {
                      lstPedidos.setModel(new PedidosListModel(selecionado.getPedidos()));   
                   }
                else
                    {
                      lstPedidos.setModel(new DefaultListModel<>());
                    }
            }
        });
        
        realizarPedido.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Mesas selecionado = lstMesas.getSelectedValue();
                   if (selecionado != null)
                   {
                       janelaPedidos pedidos = new janelaPedidos();
                       pedidos.setSize(534, 400);
                       pedidos.setLocationRelativeTo(null);
                       pedidos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //dispose
                       pedidos.setVisible(true);
                       pedidos.addWindowListener(new WindowAdapter() {
                           @Override
                           public void windowClosing(WindowEvent evt) {
                                   if (pedidos.getFechar())
                                   {
                                       Pedidos p1 = pedidos.pedidoSelecionado("Pedido " + contadorPedidos);
                                            contadorPedidos++;
                                            lstMesas.getSelectedValue().getPedidos().add(p1);
                                            lstPedidos.updateUI();
                                            lstMesas.updateUI();
                                            pedidos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                   }
                                   else
                                   {
                                        int resposta = JOptionPane.showConfirmDialog(null, "Pedido vazio. \nTerminou realmente o seu pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
                                        if (resposta == JOptionPane.YES_OPTION)
                                        {
                                                    pedidos.setVisible(false);
                                                    pedidos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        }
                                        else
                                        {  
                                            actionPerformed(e);
                                        } 
                                   }
                                }
                       });
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
               Mesas m = new Mesas("Mesa " + i, i);
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
                int numero; 
                Mesas selecionado = lstMesas.getSelectedValue();
                    if (selecionado != null)
                    {
                        numero = selecionado.getNumero();
                        List<Pedidos> pedidos = selecionado.getPedidos();
                        int itemSelecionado[][] = new int [pedidos.size()][20];
                        double [] valor = new double[pedidos.size()];
                        Calendar c = Calendar.getInstance();
                        Date data = c.getTime(); 
                                
                        int i = 0;
                        int j = 0;
                        int k = -1;
                        for (Pedidos ped : pedidos)
                        {
                            if (ped.isStatus())
                            {
                                for (k = 0; k < 20; k++)
                                {
                                    itemSelecionado[i][k] = ped.getItemSelecionado(k);
                                    //System.out.println(itemSelecionado[i][k]);
                                }
                                valor[i] = ped.getValor();
                                i++;
                                data = c.getTime();
                                ped.setFechado(data);
                                ped.setStatus(false);
                            }
                        }    
                        j = k;
                        if (j > -1)
                        {
                            JanelaConta conta = new JanelaConta(itemSelecionado, i, j, valor, data);
                            conta.setSize(534, 400);
                            conta.setLocationRelativeTo(null);
                            conta.setVisible(true);
                            conta.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent evt) {
                                conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            }
                            });
                            
                            mesas.remove(lstMesas.getSelectedValue());
                            lstMesas.clearSelection();
                            lstMesas.updateUI();
                            Mesas m = new Mesas("Mesa " + numero, numero);
                            mesas.add(m);
                            lstMesas.updateUI();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Não há pedidos em aberto para essa mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Você não selecionou uma mesa", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        
        verCardapio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaCardapio cardapio = new JanelaCardapio();
                cardapio.setSize(534, 400);
                cardapio.setLocationRelativeTo(null);
                cardapio.setVisible(true);
                cardapio.addWindowListener(new WindowAdapter() {
                @Override
                           public void windowClosing(WindowEvent evt) {
                               cardapio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                           }
                });
            }
        });
        
    }    
}
