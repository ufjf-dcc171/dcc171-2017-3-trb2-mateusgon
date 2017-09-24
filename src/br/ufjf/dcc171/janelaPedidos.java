package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.JTextField;

public class janelaPedidos extends JFrame{

    private Boolean fechar = false;
    private Pedidos pedido;
    private SampleDataPedidos pedido3 = new SampleDataPedidos();
    
    private final JPanel temp = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Pizzas Salgadas", "Pizzas Doces", "Sobremesas", "Bebidas"});
      
    private final JtextFieldSomenteNumeros [] quantidade = new JtextFieldSomenteNumeros[20];
    
    private final JLabel pizzaSalgada1 = new JLabel(pedido3.toString(0));
    private final JLabel pizzaSalgada2 = new JLabel(pedido3.toString(1));
    private final JLabel pizzaSalgada3 = new JLabel(pedido3.toString(2));
    private final JLabel pizzaSalgada4 = new JLabel(pedido3.toString(3)); 
    private final JLabel pizzaSalgada5 = new JLabel(pedido3.toString(4));
    private final JLabel pizzaSalgada6 = new JLabel(pedido3.toString(5));
    private final JLabel pizzaSalgada7 = new JLabel(pedido3.toString(6));
    private final JLabel pizzaSalgada8 = new JLabel(pedido3.toString(7));
    
    private final JLabel pizzaDoce1 = new JLabel(pedido3.toString(8));
    private final JLabel pizzaDoce2 = new JLabel(pedido3.toString(9));
    private final JLabel pizzaDoce3 = new JLabel(pedido3.toString(10));
    private final JLabel pizzaDoce4 = new JLabel(pedido3.toString(11));
   
    private final JLabel sobremesa1 = new JLabel(pedido3.toString(12));
    private final JLabel sobremesa2 = new JLabel(pedido3.toString(13));
    private final JLabel sobremesa3 = new JLabel(pedido3.toString(14));
    private final JLabel sobremesa4 = new JLabel(pedido3.toString(15));
    
    private final JLabel bebida1 = new JLabel(pedido3.toString(16));
    private final JLabel bebida2 = new JLabel(pedido3.toString(17));
    private final JLabel bebida3 = new JLabel(pedido3.toString(18));
    private final JLabel bebida4 = new JLabel(pedido3.toString(19));
    
    private final JButton confirmar = new JButton("Confirmar");
    
    public janelaPedidos() throws HeadlessException {
        super("Cardápio para Pedidos");
        setMinimumSize(new Dimension(534, 400));
        add(layouts, BorderLayout.NORTH);
        add(temp, BorderLayout.CENTER);
        for (int i = 0; i < 20; i++)
        {
            quantidade[i] = new JtextFieldSomenteNumeros();
        }
        layouts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(layouts.getSelectedIndex())
                {
                    case 0:
                        temp.removeAll();
                        temp.updateUI();
                        configuraPizzasSalgadas();
                        pack(); 
                        break;
                        
                    case 1:
                        temp.removeAll();
                        temp.updateUI();
                        configuraPizzasDoces();
                        pack();
                        break;
                    case 2:
                        temp.removeAll();
                        temp.updateUI();
                        configuraSobremesas();
                        pack();
                        break;
                    case 3:
                        temp.removeAll();
                        temp.updateUI();
                        configuraBebidas();
                        pack();
                        break;
                }
            }

            private void configuraPizzasSalgadas() {
                Box vertical = Box.createVerticalBox();
                vertical.add(pizzaSalgada1);
                vertical.add(quantidade[0]);
                vertical.add(pizzaSalgada2);
                vertical.add(quantidade[1]);
                vertical.add(pizzaSalgada3);
                vertical.add(quantidade[2]);
                vertical.add(pizzaSalgada4);
                vertical.add(quantidade[3]);
                vertical.add(pizzaSalgada5);
                vertical.add(quantidade[4]);
                vertical.add(pizzaSalgada6);
                vertical.add(quantidade[5]);
                vertical.add(pizzaSalgada7);
                vertical.add(quantidade[6]);
                vertical.add(pizzaSalgada8);
                vertical.add(quantidade[7]);
                vertical.add(confirmar);
                temp.add(vertical);
            }

            private void configuraPizzasDoces() {
                Box vertical = Box.createVerticalBox();
                vertical.add(pizzaDoce1);
                vertical.add(quantidade[8]);
                vertical.add(pizzaDoce2);
                vertical.add(quantidade[9]);
                vertical.add(pizzaDoce3);
                vertical.add(quantidade[10]);
                vertical.add(pizzaDoce4);
                vertical.add(quantidade[11]);
                vertical.add(confirmar);
                temp.add(vertical);
            }

            private void configuraSobremesas() {
                Box vertical = Box.createVerticalBox();
                vertical.add(sobremesa1);
                vertical.add(quantidade[12]);
                vertical.add(sobremesa2);
                vertical.add(quantidade[13]);
                vertical.add(sobremesa3);
                vertical.add(quantidade[14]);
                vertical.add(sobremesa4);
                vertical.add(quantidade[15]);
                vertical.add(confirmar);
                temp.add(vertical);
            }

            private void configuraBebidas() {
                Box vertical = Box.createVerticalBox();
                vertical.add(bebida1);
                vertical.add(quantidade[16]);
                vertical.add(bebida2);
                vertical.add(quantidade[17]);
                vertical.add(bebida3);
                vertical.add(quantidade[18]);
                vertical.add(bebida4);
                vertical.add(quantidade[19]);
                vertical.add(confirmar);
                temp.add(vertical);
            }
        });
     confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean possuiProdutos = false;
                int j[] = new int[20];
                for (int i = 0; i < 20; i++)
                {
                    if (!"".equals(quantidade[i].getText()))
                    {
                        j[i] = parseInt(quantidade[i].getText());
                        possuiProdutos = true;
                    }    
                    else
                        j[i] = 0;
                }
                pedido = new Pedidos();
                SampleDataPedidos sp1 = new SampleDataPedidos();
                pedido = sp1.getPedido();
                for (int i = 0; i < 20; i++)
                {
                    if (j[i] != 0)
                    {
                        double valor;
                        pedido.setValorItemIndividual((valor = pedido.getValorItemPosicao(i) * j[i]), i);
                        pedido.setValor(valor);
                    }
                }
                Calendar c = Calendar.getInstance();
                Date data = c.getTime();
                pedido.setAberto(data);
                pedido.setItemSelecionado(j);
                if (possuiProdutos)
                {
                    fechar = true;
                    JOptionPane.showMessageDialog(null, "Pedido feito e computado\n" + "Valor Total: R$" + pedido.getValor() + "\n" + "Realizado na hora: " + pedido.getAberto(), "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Seu pedido está vazio, realize-o, por-favor");
                }
            }
        });        
    }
    
    Pedidos pedidoSelecionado (String nome)
        {  
            if(nome == null)
                return null;
            else
            {
                pedido.setNome(nome);
                return this.pedido;
            }
            
        }

    public Boolean getFechar() {
        return fechar;
    }
    
    

}
