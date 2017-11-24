package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JanelaPedido extends JFrame{
  
    private boolean possuiPedidoIgualZero = false;
    private boolean confirmarNaoApertado = true;
    private boolean fecharJanelaAutorizado = false;
    private Pedido pedido;
    private final JPanel janelaPedido = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Pizzas Salgadas", "Pizzas Doces", "Sobremesas", "Bebidas"});      
    private final JtextFieldSomenteNumeros [] espacosJextFieldNumeros; 
    private final JLabel [] textosJLabels;
    private final JButton confirmar = new JButton("Confirmar");
    
    public JanelaPedido(SampleDataItem sdi) throws HeadlessException {
        super("Cardápio para Pedidos");
        setMinimumSize(new Dimension(534, 400));
        setPreferredSize(new Dimension(700, 400));
        espacosJextFieldNumeros = new JtextFieldSomenteNumeros[sdi.getItem().size()];
        textosJLabels = new JLabel[sdi.getItem().size()];
        add(layouts, BorderLayout.NORTH);
        add(new JScrollPane(janelaPedido), BorderLayout.CENTER);
        for (int i = 0; i < sdi.getItem().size(); i++)
        {
            espacosJextFieldNumeros[i] = new JtextFieldSomenteNumeros();
        }
        
        layouts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(layouts.getSelectedIndex())
                {
                    case 0:
                        janelaPedido.removeAll();
                        janelaPedido.updateUI();
                        configuraPizzasSalgadas();
                        break;
                        
                    case 1:
                        janelaPedido.removeAll();
                        janelaPedido.updateUI();
                        configuraPizzasDoces();
                        break;
                    case 2:
                        janelaPedido.removeAll();
                        janelaPedido.updateUI();
                        configuraSobremesas();;
                        break;
                    case 3:
                        janelaPedido.removeAll();
                        janelaPedido.updateUI();
                        configuraBebidas();
                        break;
                }
                
            }

            private void configuraPizzasSalgadas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().size(); i++)
                {
                    if ("Pizza Salgada".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                        vertical.add(espacosJextFieldNumeros[i]);
                    }               
                }
                vertical.add(confirmar);
                janelaPedido.add(vertical);
            }

            private void configuraPizzasDoces() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().size(); i++)
                {
                    if ("Pizza Doce".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                        vertical.add(espacosJextFieldNumeros[i]);
                    }
               }
                vertical.add(confirmar);
                janelaPedido.add(vertical);
            }

            private void configuraSobremesas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().size(); i++)
                {
                    if ("Sobremesa".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                        vertical.add(espacosJextFieldNumeros[i]);
                    }               
                }
                vertical.add(confirmar);
                janelaPedido.add(vertical);
            }

            private void configuraBebidas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().size(); i++)
                {
                    if ("Bebida".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                        vertical.add(espacosJextFieldNumeros[i]);
                    }               
                }
                vertical.add(confirmar);
                janelaPedido.add(vertical);
            }
        });
     confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean possuiProdutos = false;
                possuiPedidoIgualZero = false;
                if (confirmarNaoApertado)
                {
                    int j[] = new int[sdi.getItem().size()];
                    int i = 0;
                    int cont = 0;
                    for (i = 0; i < sdi.getItem().size(); i++)
                    {
                        if (!"".equals(espacosJextFieldNumeros[i].getText()))
                        {
                            if (espacosJextFieldNumeros[i].getText().equals("0"))
                            {
                                possuiPedidoIgualZero = true;
                            }
                            else
                            {
                                j[i] = parseInt(espacosJextFieldNumeros[i].getText());
                                cont++;
                                possuiProdutos = true;
                            }
                        }
                        else
                        {
                            j[i] = 0;
                        }
                    }
                    if (!possuiPedidoIgualZero)
                    {        
                            pedido = new Pedido();
                            ItemDoPedido [] idp = new ItemDoPedido[cont];
                            cont = 0;
                            for (i = 0; i < sdi.getItem().size(); i++)
                            {
                                if (j[i] != 0)
                                {
                                    idp[cont] = new ItemDoPedido(sdi.getItemPosicao(i), j[i]);
                                    pedido.getItemDoPedido().add(idp[cont]);
                                    cont++;
                                }
                            }
                            Calendar c = Calendar.getInstance();
                            Date data = c.getTime();
                            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");     
                            String str = fmt.format(data);
                            if (possuiProdutos)
                            {
                                pedido.setAberto(str);
                                pedido.setStatusAberto(true);
                                fecharJanelaAutorizado = true;
                                String resultado = String.format("%.2f", pedido.getValor());
                                JOptionPane.showMessageDialog(null, "Pedido feito e computado.\n" + "Valor Total: R$" + resultado + "\n" + "Realizado no dia e na hora: " + pedido.getAberto(), "Pedido realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Seu pedido está vazio, realize-o, por-favor");
                            }
                            confirmarNaoApertado = false;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Existem algum item do pedido com 0, conserte-o");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "O pedido já foi realizado!\n Encerre o cardápio no 'X'.\n Caso tenha feito o pedido errado, exclua-o na tela em seguida", "Você já confirmou seu pedido", JOptionPane.INFORMATION_MESSAGE);
                }
                    
            }
        });   
        layouts.setSelectedIndex(0);
    }

    public JanelaPedido(Pedido ped, SampleDataItem sdi) throws HeadlessException {
        super("Cardápio para Pedidos");
        setMinimumSize(new Dimension(534, 400));
        setPreferredSize(new Dimension(700, 400));
        espacosJextFieldNumeros = new JtextFieldSomenteNumeros[sdi.getItem().size()];
        textosJLabels = new JLabel[sdi.getItem().size()];
        add(layouts, BorderLayout.NORTH);
        add(janelaPedido, BorderLayout.CENTER);
        for (int i = 0; i < sdi.getItem().size(); i++)
        {
            espacosJextFieldNumeros[i] = new JtextFieldSomenteNumeros();
        }
        
        layouts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(layouts.getSelectedIndex())
                {
                    case 0:
                        janelaPedido.removeAll();
                        janelaPedido.updateUI();
                        configuraPizzasSalgadas();
                        break;
                        
                    case 1:
                        janelaPedido.removeAll();
                        janelaPedido.updateUI();
                        configuraPizzasDoces();
                        break;
                    case 2:
                        janelaPedido.removeAll();
                        janelaPedido.updateUI();
                        configuraSobremesas();;
                        break;
                    case 3:
                        janelaPedido.removeAll();
                        janelaPedido.updateUI();
                        configuraBebidas();
                        break;
                }
                
            }

            private void configuraPizzasSalgadas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().size(); i++)
                {
                    if ("Pizza Salgada".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                        vertical.add(espacosJextFieldNumeros[i]);
                    }               
                }
                vertical.add(confirmar);
                janelaPedido.add(vertical);
            }

            private void configuraPizzasDoces() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().size(); i++)
                {
                    if ("Pizza Doce".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                        vertical.add(espacosJextFieldNumeros[i]);
                    }
               }
                vertical.add(confirmar);
                janelaPedido.add(vertical);
            }

            private void configuraSobremesas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().size(); i++)
                {
                    if ("Sobremesa".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                        vertical.add(espacosJextFieldNumeros[i]);
                    }               
                }
                vertical.add(confirmar);
                janelaPedido.add(vertical);
            }

            private void configuraBebidas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().size(); i++)
                {
                    if ("Bebida".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                        vertical.add(espacosJextFieldNumeros[i]);
                    }               
                }
                vertical.add(confirmar);
                janelaPedido.add(vertical);
            }
        });
     confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean possuiProdutos = false;
                if (confirmarNaoApertado)
                {
                    int j[] = new int[sdi.getItem().size()];
                    int i = 0;
                    int cont = 0;
                    for (i = 0; i < sdi.getItem().size(); i++)
                    {
                        if (!"".equals(espacosJextFieldNumeros[i].getText()))
                        {
                            if (espacosJextFieldNumeros[i].getText().equals("0"))
                            {
                                possuiPedidoIgualZero = true;
                            }
                            else 
                            {
                                j[i] = parseInt(espacosJextFieldNumeros[i].getText());
                                cont++;
                                possuiProdutos = true;
                            }
                        }
                        else
                        {
                            j[i] = 0;
                        }
                    }
                    if (!possuiPedidoIgualZero)
                    {
                        ItemDoPedido [] idp = new ItemDoPedido[cont];
                        cont = 0;
                        for (i = 0; i < sdi.getItem().size(); i++)
                        {
                            if (j[i] != 0)
                            {
                                idp[cont] = new ItemDoPedido(sdi.getItemPosicao(i), j[i]);
                                ped.getItemDoPedido().add(idp[cont]);
                                cont++;
                            }
                        }
                        if (possuiProdutos)
                        {
                            String resultado = String.format("%.2f", ped.getValor());
                            JOptionPane.showMessageDialog(null, "Pedido feito e computado.\n" + "Valor Total: R$" + resultado + "\n" + "Realizado no dia e na hora: " + ped.getAberto(), "Pedido realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
                            fecharJanelaAutorizado = true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Seu pedido está só com itens do outro pedido, realize-o, por-favor");
                        }
                        confirmarNaoApertado = false;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Seu pedido possui 0 como entrada de algum item do pedido");  
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "O pedido já foi realizado!\n Encerre o cardápio no 'X'.\n Caso tenha feito o pedido errado, exclua-o na tela em seguida", "Você já confirmou seu pedido", JOptionPane.INFORMATION_MESSAGE);
                }
                    
            }
        });   
        layouts.setSelectedIndex(0);
    }
    
    Pedido pedidoSelecionado (String nome, Integer numero)
        {  
            if(nome == null)
                return null;
            else
            {
                pedido.setNome(nome);
                pedido.setNumero(numero);
                return this.pedido;
            }
            
        }

    public Boolean getFechar() {
        return fecharJanelaAutorizado;
    }
    
    

}
