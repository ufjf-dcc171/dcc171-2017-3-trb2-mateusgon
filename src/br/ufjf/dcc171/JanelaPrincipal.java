package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame{

    private final JPanel inicio = new JPanel();
    private final JButton administrarItem = new JButton("Administre seus itens");
    private final JButton administrarFuncionamento = new JButton("Administre o funcionamento");
    private SampleDataItem sdi;
    
    public JanelaPrincipal() throws HeadlessException {
        super("Pizzaria Petini");
        
        sdi = new SampleDataItem();
        
        setMinimumSize(new Dimension(600, 325));
        setPreferredSize(new Dimension(600, 325));
        administrarItem.setPreferredSize(new Dimension(300, 144));
        administrarFuncionamento.setPreferredSize(new Dimension(300, 144));
        administrarItem.setIcon(new ImageIcon("resources/fundo01.png"));
        administrarFuncionamento.setIcon(new ImageIcon("resources/fundo02.jpg"));
        add(administrarItem, BorderLayout.NORTH);
        add(administrarFuncionamento, BorderLayout.SOUTH);
        administrarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaControleItem inicio = new JanelaControleItem(sdi);
                inicio.setSize(730, 600);
                inicio.setLocationRelativeTo(null);
                inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                inicio.setVisible(true); 
                inicio.addWindowListener(new WindowAdapter() {
                @Override
                           public void windowClosing(WindowEvent evt) {
                               inicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                               sdi = inicio.getItem();
                           }
                });
            }
        });
        administrarFuncionamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaControleFuncionamento inicio = new JanelaControleFuncionamento(getSampleData(), sdi);
                inicio.setSize(730, 600);
                inicio.setLocationRelativeTo(null);
                inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                inicio.setVisible(true); 
            }
        });
        
       
    }
    
    private static List<Mesas> getSampleData()
    {
            Mesas m1 = new Mesas("Mesa 0", 0);
            List<Mesas> mesas = new ArrayList<>();
            mesas.add(m1);
            return mesas;    
    }
        
}
