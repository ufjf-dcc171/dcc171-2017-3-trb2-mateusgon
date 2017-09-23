package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class janelaPedidos extends JFrame{

    private final JtextFieldSomenteNumeros a = new JtextFieldSomenteNumeros();
    
    private final JPanel temp = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Pizzas Salgadas", "Pizzas Doces", "Sobremesas", "Bebidas"});
    
    private final JButton confirmar = new JButton("Confirmar");
    
    public janelaPedidos() throws HeadlessException {
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
                        configuraPizzasSalgadas();
                        pack(); 
                        break;
                    case 1:
                        configuraPizzasDoces();
                        pack();
                        break;
                    case 2:
                        configuraSobremesas();
                        pack();
                        break;
                    case 3:
                        configuraBebidas();
                        pack();
                        break;
                }
            }

            private void configuraPizzasSalgadas() {
                
                Box vertical = Box.createVerticalBox();
                vertical.add(a);
                vertical.add(confirmar);
                temp.add(vertical);
            }

            private void configuraPizzasDoces() {
                Box vertical = Box.createVerticalBox();
            }

            private void configuraSobremesas() {
                Box vertical = Box.createVerticalBox();
            }

            private void configuraBebidas() {
                Box vertical = Box.createVerticalBox();
            }
        });
        
     
        
    }
    
}
