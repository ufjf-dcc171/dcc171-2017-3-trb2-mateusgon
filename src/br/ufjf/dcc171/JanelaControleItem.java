package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JanelaControleItem extends JFrame{

    private final SampleDataItem item;
    private String TipoItem;
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
                JButton confirmar = new JButton("Confirmar");
                ButtonGroup btg = new ButtonGroup();
                JTextField [] texto = new JTextField[2];
                Box vertical = Box.createVerticalBox();
                Box horizontal = Box.createHorizontalBox();
                Box horizontal2 = Box.createHorizontalBox();
                Box horizontal3 = Box.createHorizontalBox();
                JRadioButton [] chk = new JRadioButton[4];
                JLabel [] adicionar = new JLabel[3];
                
                adicionar[0] = new JLabel("Nome: ");
                texto[0] = new JTextField("Nome (Descrição)");
                adicionar[1] = new JLabel("Tipo do Item: ");
                chk[0] = new JRadioButton("Pizza Salgada");
                chk[1] = new JRadioButton("Pizza Doce");
                chk[2] = new JRadioButton("Pizza Sobremesa");
                chk[3] = new JRadioButton("Bebida");
                adicionar[2] = new JLabel("Valor: ");
                texto[1] = new JTextField("0.00");
                
                horizontal.add(adicionar[0]);
                horizontal.add(texto[0]);
                vertical.add(horizontal);
                horizontal2.add(adicionar[1]);
                horizontal2.add(chk[0]);
                horizontal2.add(chk[1]);
                horizontal2.add(chk[2]);
                horizontal2.add(chk[3]);
                btg.add(chk[0]);
                btg.add(chk[1]);
                btg.add(chk[2]);
                btg.add(chk[3]);
               
                vertical.add(horizontal2);
                horizontal3.add(adicionar[2]);
                horizontal3.add(texto[1]);
                vertical.add(horizontal3);
                vertical.add(confirmar);
                janelaItem.add(vertical);
                
                chk[0].addItemListener(new TipoItem("Pizza Salgada"));
                chk[1].addItemListener(new TipoItem("Pizza Doce"));
                chk[2].addItemListener(new TipoItem("Sobremesa"));
                chk[3].addItemListener(new TipoItem("Bebida"));
                
                confirmar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Item novo = new Item();
                        novo.setNome(texto[0].getText());
                        novo.setTipoItem(TipoItem);
                        Double valor = Double.parseDouble(texto[1].getText());
                        novo.setValor(valor);
                        getItem().getItem().add(novo);
                        System.out.println(texto[0].getText());
                        System.out.println(texto[1].getText());
                        System.out.println(TipoItem);
                    }
                });
                
            }

            private void configurarAlterar() {
                
            }

            private void configurarExcluir() {
                
            }

        });
    }

    public SampleDataItem getItem() {
        return item;
    }

    private class TipoItem implements ItemListener {

        String tipoItem;
        public TipoItem(String tipo) {
            tipoItem = tipo;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            TipoItem = tipoItem;
        }
        
    }
    
}
