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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame{
    
    private int contadorPedidos = 0;
    private boolean abrirJanela = true;
    private final JPanel inicio = new JPanel();
    private final JButton administrarItem = new JButton("Administre seus itens");
    private final JButton administrarFuncionamento = new JButton("Administre o funcionamento");
    private SampleDataItem sdi;
    private List<Mesas> mesas = new ArrayList<>();
    
    public JanelaPrincipal() throws HeadlessException {
        super("Pizzaria Petini - Bem-vindo");
        
        sdi = new SampleDataItem();
        Mesas mesa = new Mesas("Mesa 0", 0);
        mesas.add(mesa);
        
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
                if(abrirJanela)
                {
                    abrirJanela = false;
                    JanelaControleItem inicio = new JanelaControleItem(sdi);
                    inicio.setSize(650, 350);
                    inicio.setLocationRelativeTo(null);
                    inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    inicio.setVisible(true); 
                    inicio.addWindowListener(new WindowAdapter() {
                    @Override
                               public void windowClosing(WindowEvent evt) {
                                   inicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                   sdi = inicio.getItem();
                                   abrirJanela = true;
                               }
                    });
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Você deve fechar a janela aberta primeiro.", "Feche a janela aberta.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        administrarFuncionamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (abrirJanela)
                {
                    abrirJanela = false;
                    JanelaControleFuncionamento inicio = new JanelaControleFuncionamento(mesas, sdi, contadorPedidos);
                    inicio.setSize(730, 600);
                    inicio.setLocationRelativeTo(null);
                    inicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    inicio.setVisible(true);
                    inicio.addWindowListener(new WindowAdapter() {
                    @Override
                               public void windowClosing(WindowEvent evt) {
                                   inicio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                   mesas = inicio.getMesas();
                                   contadorPedidos = inicio.getContadorPedidos();
                                   abrirJanela = true;
                                   
                               }
                    });
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Você deve fechar a janela aberta primeiro.", "Feche a janela aberta.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
       
    }  
}
