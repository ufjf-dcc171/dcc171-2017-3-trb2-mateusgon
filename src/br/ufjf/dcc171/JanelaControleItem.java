package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class JanelaControleItem extends JFrame{

    private final Item modificado;
    private final SampleDataItem item;
    private String TipoItem;
    private JPanel janelaItem = new JPanel();
    private final JComboBox<String> layouts = new JComboBox<>(new String[]{"Adicionar", "Alterar", "Remover"});  
    
    public JanelaControleItem(SampleDataItem sdi) throws HeadlessException {
        super("Administração de Itens");
        this.modificado=null;
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
                vertical.add(confirmar, BorderLayout.SOUTH);
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
                        sdi.getItem().add(novo);
                    }
                });
                
            }

            private void configurarAlterar() {
                JButton alterar = new JButton("Alterar");
                JList<Item> lstItem = new JList<>(new DefaultListModel<>());
                lstItem.setModel(new ItemListModel(item.getItem()));
                lstItem.setMinimumSize(new Dimension(500, 500));
                lstItem.setPreferredSize(new Dimension(500, 500));
                janelaItem.add(new JScrollPane(lstItem), BorderLayout.CENTER);
                janelaItem.add(alterar);
                lstItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                alterar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                Item selecionado = lstItem.getSelectedValue();
                   if (selecionado != null)
                   {
                       int i = sdi.getItem().indexOf(selecionado);
                       JanelaControleItem modific = new JanelaControleItem(sdi.getItem().get(i));
                       modific.setSize(150, 150);
                       modific.setLocationRelativeTo(null);
                       modific.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                       modific.setVisible(true);
                       modific.addWindowListener(new WindowAdapter() {
                           @Override
                           public void windowClosing(WindowEvent evt) {
                               modific.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                               Item a = modific.getModificado();
                               sdi.getItem().get(i).setNome(a.getNome());
                               sdi.getItem().get(i).setTipoItem(a.getTipoItem());
                               sdi.getItem().get(i).setValor(a.getValor());
                           }
                       });
                       lstItem.clearSelection();
                       lstItem.updateUI();
                   } 
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Item.", "Selecione um Item.", JOptionPane.INFORMATION_MESSAGE);
                   }
            }
            }); 
               }    

            private void configurarExcluir() {
                JButton remover = new JButton("Remover");
                JList<Item> lstItem = new JList<>(new DefaultListModel<>());
                lstItem.setModel(new ItemListModel(item.getItem()));
                lstItem.setMinimumSize(new Dimension(500, 500));
                lstItem.setPreferredSize(new Dimension(500, 500));
                janelaItem.add(new JScrollPane(lstItem), BorderLayout.CENTER);
                janelaItem.add(remover);
                lstItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                remover.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                Item selecionado = lstItem.getSelectedValue();
                   if (selecionado != null)
                   {
                       sdi.getItem().remove(selecionado); 
                       lstItem.clearSelection();
                       lstItem.updateUI();
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Você deveria ter selecionado um Item.", "Selecione um Item.", JOptionPane.INFORMATION_MESSAGE);
                   }
                }
            });
         }
        });
    }
        
    public SampleDataItem getItem() {
        return item;
    }

    public Item getModificado() {
        return modificado;
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

    public JanelaControleItem(Item i) throws HeadlessException {
        super("Modificando Item");
        this.item = null;
        this.modificado = i;
        add(janelaItem, BorderLayout.CENTER);
        JButton confirmar = new JButton("Confirmar");
        ButtonGroup btg = new ButtonGroup();
        JTextField[] texto = new JTextField[2];
        Box vertical = Box.createVerticalBox();
        Box horizontal = Box.createHorizontalBox();
        Box horizontal2 = Box.createHorizontalBox();
        Box horizontal3 = Box.createHorizontalBox();
        JRadioButton[] chk = new JRadioButton[4];
        JLabel[] adicionar = new JLabel[3];

        adicionar[0] = new JLabel("Nome: ");
        texto[0] = new JTextField(i.getNome());
        adicionar[1] = new JLabel("Tipo do Item: ");
        chk[0] = new JRadioButton("Pizza Salgada");
        chk[1] = new JRadioButton("Pizza Doce");
        chk[2] = new JRadioButton("Pizza Sobremesa");
        chk[3] = new JRadioButton("Bebida");
        adicionar[2] = new JLabel("Valor: ");
        texto[1] = new JTextField("R$" + i.getValor() + "(Tire o 'R$')");

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
        vertical.add(confirmar, BorderLayout.SOUTH);
        janelaItem.add(vertical);

        chk[0].addItemListener(new TipoItem("Pizza Salgada"));
        chk[1].addItemListener(new TipoItem("Pizza Doce"));
        chk[2].addItemListener(new TipoItem("Sobremesa"));
        chk[3].addItemListener(new TipoItem("Bebida"));

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getModificado().setNome(texto[0].getText());
                getModificado().setTipoItem(TipoItem);
                Double valor = Double.parseDouble(texto[1].getText());
                getModificado().setValor(valor);               
            }
        });

}
    
    
    
}