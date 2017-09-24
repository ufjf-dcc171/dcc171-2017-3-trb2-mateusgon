
package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaCardapio extends JFrame {
    
    private SampleDataPedidos pedido3 = new SampleDataPedidos();
    private final JPanel temp = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Pizzas Salgadas", "Pizzas Doces", "Sobremesas", "Bebidas"});
   
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

    public JanelaCardapio() throws HeadlessException {
    super("Cardápio");
        setMinimumSize(new Dimension(534, 400));
        add(layouts, BorderLayout.NORTH);
        add(temp, BorderLayout.CENTER);
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
                vertical.add(pizzaSalgada2);
                vertical.add(pizzaSalgada3);
                vertical.add(pizzaSalgada4);
                vertical.add(pizzaSalgada5);
                vertical.add(pizzaSalgada6);
                vertical.add(pizzaSalgada7);
                vertical.add(pizzaSalgada8);
                temp.add(vertical);
            }

            private void configuraPizzasDoces() {
                Box vertical = Box.createVerticalBox();
                vertical.add(pizzaDoce1);
                vertical.add(pizzaDoce2);
                vertical.add(pizzaDoce3);
                vertical.add(pizzaDoce4);
                temp.add(vertical);
            }

            private void configuraSobremesas() {
                Box vertical = Box.createVerticalBox();
                vertical.add(sobremesa1);
                vertical.add(sobremesa2);
                vertical.add(sobremesa3);
                vertical.add(sobremesa4);
                temp.add(vertical);
            }

            private void configuraBebidas() {
                Box vertical = Box.createVerticalBox();
                vertical.add(bebida1);
                vertical.add(bebida2);
                vertical.add(bebida3);
                vertical.add(bebida4);
                temp.add(vertical);
            }
        });
    
    }
    
}
