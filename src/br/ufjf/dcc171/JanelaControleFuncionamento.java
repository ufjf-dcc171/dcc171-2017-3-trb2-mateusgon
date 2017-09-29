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

public class JanelaControleFuncionamento extends JFrame {
        
        private int i;
        private int contadorPedidos=0;
        private final List<Mesas> mesas;
        private final JList<Mesas> lstMesas = new JList<>(new DefaultListModel<>());
        private final JList<Pedido> lstPedidos = new JList<>(new DefaultListModel<>());
        private final JButton adicionarMesa = new JButton("Adicionar Mesa");
        private final JButton excluirMesa = new JButton("Excluir Mesa");
        private final JButton realizarPedido = new JButton("Realizar Pedido");
        private final JButton fecharConta = new JButton("Fechar Conta");
        private final JButton verCardapio = new JButton("Ver Cardapio");
        private final JButton excluirPedido = new JButton("Excluir Pedido");
        private final JButton totalFaturado = new JButton("Total Faturado");
        private final JButton verPedido = new JButton("Ver Pedido");
    
    public JanelaControleFuncionamento(List<Mesas> sampleData) throws HeadlessException {
        super("Controle de Pedidos");
        setPreferredSize(new Dimension(730, 600));
        setMinimumSize(new Dimension(500, 400));
        
        
        this.mesas = sampleData;
        lstMesas.setModel(new MesasListModel(mesas));
        
        lstMesas.setPreferredSize(new Dimension(200, 200));
        lstPedidos.setPreferredSize(new Dimension(500, 200));
        
        SampleDataItem sdi = new SampleDataItem();
        
        JPanel botoes = new JPanel(new GridLayout(2, 4));
        botoes.add(adicionarMesa);
        botoes.add(realizarPedido);
        botoes.add(verCardapio);
        botoes.add(totalFaturado);
        botoes.add(excluirMesa);
        botoes.add(excluirPedido);
        botoes.add(verPedido);
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
                      lstPedidos.clearSelection();
                   }
                else
                    {
                      lstPedidos.setModel(new DefaultListModel<>());
                      lstPedidos.clearSelection();
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
                       JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa.", "Selecione uma mesa.", JOptionPane.INFORMATION_MESSAGE);
                   }
            }
        });
        
        realizarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mesas selecionado = lstMesas.getSelectedValue();
                Pedido selecionado2 = lstPedidos.getSelectedValue();
                if (selecionado == null) {
                    JOptionPane.showMessageDialog(null, "Você precisa selecionar uma mesa", "Selecione uma mesa.", JOptionPane.INFORMATION_MESSAGE);
                } else if ((selecionado != null && selecionado2 == null) && (selecionado.getPedidos().isEmpty() || !selecionado.getPedidos().get(0).isStatusAberto())) {
                    JanelaPedido realizarPedido = new JanelaPedido(sdi);
                    realizarPedido.setSize(534, 400);
                    realizarPedido.setLocationRelativeTo(null);
                    realizarPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    realizarPedido.setVisible(true);
                    realizarPedido.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent evt) {
                            if (realizarPedido.getFechar()) {
                                Pedido p1 = realizarPedido.pedidoSelecionado("Pedido " + contadorPedidos);
                                contadorPedidos++;
                                lstMesas.getSelectedValue().getPedidos().add(p1);
                                lstPedidos.updateUI();
                                lstMesas.updateUI();
                                realizarPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            } else {
                                int resposta = JOptionPane.showConfirmDialog(null, "Pedido vazio. \nTerminou realmente o seu pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
                                if (resposta == JOptionPane.YES_OPTION) {
                                    realizarPedido.setVisible(false);
                                    realizarPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                } else {
                                    actionPerformed(e);
                                }
                            }
                        }
                    });
                } else if (selecionado != null && selecionado2 != null) {
                       if (selecionado2.isStatusAberto()) {
                        JanelaPedido realizarPedido = new JanelaPedido(selecionado2, sdi);
                        realizarPedido.setSize(534, 400);
                        realizarPedido.setLocationRelativeTo(null);
                        realizarPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        realizarPedido.setVisible(true);
                        realizarPedido.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent evt) {
                                if (realizarPedido.getFechar()) {
                                    lstPedidos.updateUI();
                                    lstMesas.updateUI();
                                    realizarPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                } else {
                                    int resposta = JOptionPane.showConfirmDialog(null, "Pedido vazio. \nTerminou realmente o seu pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
                                    if (resposta == JOptionPane.YES_OPTION) {
                                        realizarPedido.setVisible(false);
                                        realizarPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    } else {
                                        actionPerformed(e);
                                    }
                                }
                            }
                        });
                        
                    }
                       else
                       {
                           JOptionPane.showMessageDialog(null, "Você selecionou um pedido já fechado", "Pedido Fechado.", JOptionPane.INFORMATION_MESSAGE);
                       }
                } else {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado o pedido.", "Selecione um pedido.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        excluirPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mesas selecionado = lstMesas.getSelectedValue();
                Pedido selecionado2 = lstPedidos.getSelectedValue();
                if (selecionado != null && selecionado2 != null)
                {
                    selecionado.getPedidos().remove(selecionado2);
                    lstMesas.clearSelection();
                    lstPedidos.clearSelection();
                    lstMesas.updateUI();
                    lstPedidos.updateUI();
                }
                else if (selecionado == null)
                {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa.", "Selecione uma mesa.", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um pedido.", "Selecione um pedido.", JOptionPane.INFORMATION_MESSAGE);
                }
                    
            }
        });
        
        verCardapio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaCardapio cardapio = new JanelaCardapio(sdi);
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
        
        verPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mesas selecionado = lstMesas.getSelectedValue();
                Pedido selecionado2 = lstPedidos.getSelectedValue();
                JanelaListaPedido jlp;
                if (selecionado != null && selecionado2 != null)
                {
                    jlp = new JanelaListaPedido(selecionado2);
                    jlp.setSize(534, 400);
                    jlp.setLocationRelativeTo(null);
                    jlp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jlp.setVisible(true);
                }
                else if (selecionado != null && selecionado.getPedidos().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Não existem pedidos para essa mesa.", "Não há pedidos.", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (selecionado != null && selecionado2 == null)
                {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um pedido.", "Selecione um pedido.", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Você deveria ter selecionado uma mesa.", "Selecione uma mesa.", JOptionPane.INFORMATION_MESSAGE);
                }    
                 
            }
        });
                
        
        fecharConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero; 
                Mesas selecionado = lstMesas.getSelectedValue();
                Pedido selecionado2 = lstPedidos.getSelectedValue();
                    if (selecionado != null && selecionado2 != null && selecionado2.isStatusAberto())
                    {
                        JanelaConta jc = new JanelaConta(selecionado2);
                        jc.setSize(534, 400);
                        jc.setLocationRelativeTo(null);
                        jc.setVisible(true);
                        jc.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosing(WindowEvent evt) {
                                jc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            }
                            });                       
                        lstMesas.clearSelection();
                        lstPedidos.clearSelection();
                        lstMesas.updateUI();
                        lstPedidos.updateUI();
                        }
                    else if (selecionado != null)
                    {
                        JOptionPane.showMessageDialog(null, "Você não selecionou um pedido para fechar.", "Selecione um pedido", JOptionPane.INFORMATION_MESSAGE);
                    }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Você não selecionou uma mesa.", "Selecione uma mesa com pedido.", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
        });   
    }    
}