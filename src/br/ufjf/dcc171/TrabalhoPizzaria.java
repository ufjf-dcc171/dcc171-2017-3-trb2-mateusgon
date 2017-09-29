package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class TrabalhoPizzaria {

    public static void main(String[] args) {
        JanelaControleFuncionamento inicio = new JanelaControleFuncionamento(getSampleData());
        inicio.setSize(730, 600);
        inicio.setLocationRelativeTo(null);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
    }
    private static List<Mesas> getSampleData()
    {
            Mesas m1 = new Mesas("Mesa 0", 0);
            List<Mesas> mesas = new ArrayList<>();
            mesas.add(m1);
            return mesas;    
    }

}
