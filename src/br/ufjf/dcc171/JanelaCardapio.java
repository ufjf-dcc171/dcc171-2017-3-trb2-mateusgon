
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

    private final JLabel [] textosJLabels; 
    private JPanel janelaCardapio = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Pizzas Salgadas", "Pizzas Doces", "Sobremesas", "Bebidas"});  
    
    public JanelaCardapio(SampleDataItem sdi) throws HeadlessException {
        super("Cardápio para Pedidos");
        setMinimumSize(new Dimension(534, 400));
        setPreferredSize(new Dimension(700, 400));
        textosJLabels = new JLabel[sdi.getItem().length];
        add(layouts, BorderLayout.NORTH);
        add(janelaCardapio, BorderLayout.CENTER);        
        layouts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(layouts.getSelectedIndex())
                {
                    case 0:
                        janelaCardapio.removeAll();
                        janelaCardapio.updateUI();
                        configuraPizzasSalgadas();
                        break;
                        
                    case 1:
                        janelaCardapio.removeAll();
                        janelaCardapio.updateUI();
                        configuraPizzasDoces();
                        break;
                    case 2:
                        janelaCardapio.removeAll();
                        janelaCardapio.updateUI();
                        configuraSobremesas();;
                        break;
                    case 3:
                        janelaCardapio.removeAll();
                        janelaCardapio.updateUI();
                        configuraBebidas();
                        break;
                }
                
            }
            private void configuraPizzasSalgadas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().length; i++)
                {
                    if ("Pizza Salgada".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                    }               
                }
                janelaCardapio.add(vertical);
            }

            private void configuraPizzasDoces() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().length; i++)
                {
                    if ("Pizza Doce".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                    }
               }
                janelaCardapio.add(vertical);
            }

            private void configuraSobremesas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().length; i++)
                {
                    if ("Sobremesa".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);;
                    }               
                }
                janelaCardapio.add(vertical);
            }

            private void configuraBebidas() {
                Box vertical = Box.createVerticalBox();
                for (int i = 0; i < sdi.getItem().length; i++)
                {
                    if ("Bebida".equals(sdi.getTipo(i)))
                    {
                        textosJLabels[i] = new JLabel(sdi.nomeValor(i));
                        vertical.add(textosJLabels[i]);
                    }               
                }
                janelaCardapio.add(vertical);
            }
        });
        layouts.setSelectedIndex(0);
    }
}
