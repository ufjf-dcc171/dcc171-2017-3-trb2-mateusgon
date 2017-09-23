package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class TrabalhoPizzaria {

    public static void main(String[] args) {
        janelaControle mesas = new janelaControle(getSampleData());
        mesas.setSize(534, 400);
        mesas.setLocationRelativeTo(null);
        mesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mesas.setVisible(true);
    }
    private static List<Mesas> getSampleData()
        {
            Mesas m1 = new Mesas("Mesa 0");
            List<Mesas> mesas = new ArrayList<>();
            mesas.add(m1);
            return mesas;
        }
}
