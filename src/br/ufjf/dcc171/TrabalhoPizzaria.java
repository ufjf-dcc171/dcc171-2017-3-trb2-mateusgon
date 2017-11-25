package br.ufjf.dcc171;

import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JFrame;

public class TrabalhoPizzaria {

    public static void main(String[] args) throws HeadlessException, IOException {
        JanelaPrincipal inicio = new JanelaPrincipal();
        inicio.setSize(600, 325);
        inicio.setLocationRelativeTo(null);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setVisible(true);
    }
}
