package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaConta extends JFrame{

    private int j=0;
    private int m=0;
    private final SampleDataPedidos pedido3 = new SampleDataPedidos();
    private final JLabel[] labels;
    private int posicaoLables = 0;
    private double valorFinalConta=0;
    
    public JanelaConta(int[][] itemSelecionado, int i, int k, double [] valor) {
        super("Conta");
        this.labels = new JLabel[(i * 20) + 1];
        setMinimumSize(new Dimension(534, 400));
        Box vertical = Box.createVerticalBox();
        for (j = 0; j < i; j++)
        {
            for (m = 0; m < k; m++)
            {
                if (itemSelecionado[j][m] != 0)
                {
                    labels[posicaoLables] = new JLabel(pedido3.toString(m, itemSelecionado[j][m]));
                    posicaoLables++;
                }
            }
        }
        for (int a = 0; a < posicaoLables; a++)
        {
            vertical.add(labels[a]);
        }
        for (int a = 0; a < valor.length; a++)
        {
            valorFinalConta = valorFinalConta + valor[a];
        }
        labels[labels.length-1] = new JLabel("O valor total é R$" + valorFinalConta);
        vertical.add(labels[labels.length-1]);
        add(vertical, BorderLayout.CENTER);
    }
    
}
