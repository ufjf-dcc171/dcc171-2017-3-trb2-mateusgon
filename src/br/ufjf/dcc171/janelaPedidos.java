package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private final JPanel temp = new JPanel();
    private final JPanel temp2 = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Pizzas Salgadas", "Pizzas Doces", "Sobremesas", "Bebidas"});
    
    private final JRadioButton pequena = new JRadioButton("Pequena", true);
    private final JRadioButton media = new JRadioButton ("Media", false);
    private final JRadioButton grande = new JRadioButton ("Grande", false);
    private final ButtonGroup botoes = new ButtonGroup();
    
    private final JLabel pizzaSalgada1 = new JLabel("1 - Pepperoni (Pepperoni e Manjericão) - R$38,90");
    private final JtextFieldSomenteNumeros vPizzaSalgada1 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaSalgada2 = new JLabel("2 - Champignon (Champignon e Azeitona Preta) - R$38,90");
    private final JtextFieldSomenteNumeros vPizzaSalgada2 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaSalgada3 = new JLabel("3 - Pizza ao alho (Alho torrado e Azeite) - R$38,90");
    private final JtextFieldSomenteNumeros vPizzaSalgada3 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaSalgada4 = new JLabel("4 - Portuguesa (Presunto, ovo, cebola e azeitona preta) - R$38,90");
    private final JtextFieldSomenteNumeros vPizzaSalgada4 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaSalgada5 = new JLabel("5 - Frango c/ requeijão (Peito de frango, azeitona preta e requeijão) - R$38,90");
    private final JtextFieldSomenteNumeros vPizzaSalgada5 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaSalgada6 = new JLabel("6 - 4 queijos (Provolone, requeijão, parmesão e mussarela) - R$38,90");
    private final JtextFieldSomenteNumeros vPizzaSalgada6 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaSalgada7 = new JLabel("7 - Napolitana (Parmesão e muito mais rodelas de tomate) - R$38,90");
    private final JtextFieldSomenteNumeros vPizzaSalgada7 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaSalgada8 = new JLabel("8 - Palmito (Presunto, plamito, azeitona preta e manjericão) - R$38,90");
    private final JtextFieldSomenteNumeros vPizzaSalgada8 = new JtextFieldSomenteNumeros();
    
    private final JLabel pizzaDoce1 = new JLabel("1 - Banana com Canela (Mussarela, Banana, açúcar, canela) - R$40,90");
    private final JtextFieldSomenteNumeros vPizzaDoce1 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaDoce2 = new JLabel("2 - Brigadeiro (Mussarela, chocolate e granulado de chocolate) - R$40,90");
    private final JtextFieldSomenteNumeros vPizzaDoce2 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaDoce3 = new JLabel("3 - Roma (Mussarela, banana, açúcar, canela e chocolate) - R$40,90");
    private final JtextFieldSomenteNumeros vPizzaDoce3 = new JtextFieldSomenteNumeros();
    private final JLabel pizzaDoce4 = new JLabel("4 - Bibiena (Massa de chocolate, chocolate, mini-confetes) - R$40,90");
    private final JtextFieldSomenteNumeros vPizzaDoce4 = new JtextFieldSomenteNumeros();
    
    
    private final JButton confirmar = new JButton("Confirmar");
    
    public janelaPedidos() throws HeadlessException {
        super("Cardápio");
        setMinimumSize(new Dimension(534, 400));
        botoes.add(pequena);
        botoes.add(media);
        botoes.add(grande);
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
                vertical.add(vPizzaSalgada1);
                vertical.add(pizzaSalgada2);
                vertical.add(vPizzaSalgada2);
                vertical.add(pizzaSalgada3);
                vertical.add(vPizzaSalgada3);
                vertical.add(pizzaSalgada4);
                vertical.add(vPizzaSalgada4);
                vertical.add(pizzaSalgada5);
                vertical.add(vPizzaSalgada5);
                vertical.add(pizzaSalgada6);
                vertical.add(vPizzaSalgada6);
                vertical.add(pizzaSalgada7);
                vertical.add(vPizzaSalgada7);
                vertical.add(pizzaSalgada8);
                vertical.add(vPizzaSalgada8);
                vertical.add(confirmar);
                temp.add(vertical);
            }

            private void configuraPizzasDoces() {
                Box vertical = Box.createVerticalBox();
                vertical.add(pizzaDoce1);
                vertical.add(vPizzaDoce1);
                vertical.add(pizzaDoce2);
                vertical.add(vPizzaDoce2);
                vertical.add(pizzaDoce3);
                vertical.add(vPizzaDoce3);
                vertical.add(pizzaDoce4);
                vertical.add(vPizzaDoce4);
                vertical.add(confirmar);
                temp.add(vertical);
            }

            private void configuraSobremesas() {
                Box vertical = Box.createVerticalBox();
            }

            private void configuraBebidas() {
                Box vertical = Box.createVerticalBox();
            }
        });
        
     confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   
            }
        });
        
    }
    
}
