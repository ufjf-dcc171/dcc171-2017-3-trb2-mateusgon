package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
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

    private Pedidos pedido;
    
    private final JPanel temp = new JPanel();
    private final JPanel temp2 = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Pizzas Salgadas", "Pizzas Doces", "Sobremesas", "Bebidas"});
      
    private final JtextFieldSomenteNumeros [] quantidade = new JtextFieldSomenteNumeros[20];
    
    private final JLabel pizzaSalgada1 = new JLabel("1 - Pepperoni (Pepperoni e Manjericão) - R$38,90");
    private final JLabel pizzaSalgada2 = new JLabel("2 - Champignon (Champignon e Azeitona Preta) - R$38,90");
    private final JLabel pizzaSalgada3 = new JLabel("3 - Pizza ao alho (Alho torrado e Azeite) - R$38,90");
    private final JLabel pizzaSalgada4 = new JLabel("4 - Portuguesa (Presunto, ovo, cebola e azeitona preta) - R$38,90");
    private final JLabel pizzaSalgada5 = new JLabel("5 - Frango c/ requeijão (Peito de frango, azeitona preta e requeijão) - R$38,90");
    private final JLabel pizzaSalgada6 = new JLabel("6 - 4 queijos (Provolone, requeijão, parmesão e mussarela) - R$38,90");
    private final JLabel pizzaSalgada7 = new JLabel("7 - Napolitana (Parmesão e muito mais rodelas de tomate) - R$38,90");
    private final JLabel pizzaSalgada8 = new JLabel("8 - Palmito (Presunto, plamito, azeitona preta e manjericão) - R$38,90");
    
    private final JLabel pizzaDoce1 = new JLabel("1 - Banana com Canela (Mussarela, Banana, açúcar, canela) - R$40,90");
    private final JLabel pizzaDoce2 = new JLabel("2 - Brigadeiro (Mussarela, chocolate e granulado de chocolate) - R$40,90");
    private final JLabel pizzaDoce3 = new JLabel("3 - Roma (Mussarela, banana, açúcar, canela e chocolate) - R$40,90");
    private final JLabel pizzaDoce4 = new JLabel("4 - Bibiena (Massa de chocolate, chocolate, mini-confetes) - R$40,90");
   
    private final JLabel sobremesa1 = new JLabel("1 - Sorvete Napolitano - R$5,00");
    private final JLabel sobremesa2 = new JLabel("2 - Petit Gateau e Sorvete Napolitano - R$13,00");
    private final JLabel sobremesa3 = new JLabel("3 - Banana Split - R$10,00");
    private final JLabel sobremesa4 = new JLabel("4 - Milk-Shake - R$9,00");
    
    private final JLabel bebida1 = new JLabel("1 - Refrigerante de 500ml - R$6,00");
    private final JLabel bebida2 = new JLabel("2 - Refrigerante de 1,5lts - R$10,00");
    private final JLabel bebida3 = new JLabel("3 - Suco Copo - R$5,00");
    private final JLabel bebida4 = new JLabel("4 - Cerveja Long Neck - R$7,00");
    
    private final JButton confirmar = new JButton("Confirmar");
    
    public janelaPedidos() throws HeadlessException {
        super("Cardápio");
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
                pedido = new Pedidos();
                switch(layouts.getSelectedIndex())
                {
                    case 0:
                        temp.removeAll();
                        temp.updateUI();
                        configuraPizzasSalgadas(pedido);
                        pack(); 
                        break;
                        
                    case 1:
                        temp.removeAll();
                        temp.updateUI();
                        configuraPizzasDoces(pedido);
                        pack();
                        break;
                    case 2:
                        temp.removeAll();
                        temp.updateUI();
                        configuraSobremesas(pedido);
                        pack();
                        break;
                    case 3:
                        temp.removeAll();
                        temp.updateUI();
                        configuraBebidas(pedido);
                        pack();
                        break;
                }
            }

            private void configuraPizzasSalgadas(Pedidos pedido) {
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

            private void configuraPizzasDoces(Pedidos pedido) {
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

            private void configuraSobremesas(Pedidos pedido) {
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

            private void configuraBebidas(Pedidos pedido) {
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
                int j[] = new int[20];
                for (int i = 0; i < 20; i++)
                {
                    if (!"".equals(quantidade[i].getText()))
                        j[i] = parseInt(quantidade[i].getText());
                    else
                        j[i] = 0;
                } 
                pedido = new Pedidos("Teste");
            }
        });        
    }
    
    Pedidos pedidoSelecionado ()
        {
            return this.pedido;
        }
    
}
