package br.ufjf.dcc171;

import javax.swing.JFrame;

public class TrabalhoPizzaria {

    public static void main(String[] args) {
        janelaControle mesas = new janelaControle();
        mesas.setSize(534, 400);
        mesas.setLocationRelativeTo(null);
        mesas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mesas.setVisible(true);
    }
    
}
