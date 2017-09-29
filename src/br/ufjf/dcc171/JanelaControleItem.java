package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JanelaControleItem extends JFrame{

    private final SampleDataItem item;
    private JPanel janelaItem = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Adicionar", "Alterar", "Remover"});  
    
    public JanelaControleItem(SampleDataItem sdi) throws HeadlessException {
        super("Administração de Itens");
        item = sdi;
        add(layouts, BorderLayout.NORTH);
        add(new JScrollPane(janelaItem), BorderLayout.CENTER);
        layouts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               switch(layouts.getSelectedIndex())
                {
                    case 0:
                        janelaItem.removeAll();
                        janelaItem.updateUI();
                        configurarAdicionar();
                        break;
                        
                    case 1:
                        janelaItem.removeAll();
                        janelaItem.updateUI();
                        configurarAlterar();
                        break;
                    case 2:
                        janelaItem.removeAll();
                        janelaItem.updateUI();
                        configurarExcluir();
                        break;
                }
            }

            private void configurarAdicionar() {
                Box vertical = Box.createVerticalBox();
                JLabel [] adicionar = new JLabel[3];
                adicionar[0] = new JLabel("Nome");
            }

            private void configurarAlterar() {
                }

            private void configurarExcluir() {
               }
        });
    }
    
}
