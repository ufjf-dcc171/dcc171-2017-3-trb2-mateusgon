package br.ufjf.dcc171;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class Diretorio {

    private File arquivo = new File("funcionamento.txt");
    private FileWriter arquivoFuncionamento;
    private FileWriter arquivoItem;

    public Diretorio() {
        if (!arquivo.exists())
            try {
                arquivoFuncionamento = new FileWriter("funcionamento.txt");    
                arquivoItem = new FileWriter("item.txt");    
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            }
        }
  
    public FileWriter getArquivoFuncionamento() {
        return arquivoFuncionamento;
    }

    public void setArquivoFuncionamento(FileWriter arquivoFuncionamento) {
        this.arquivoFuncionamento = arquivoFuncionamento;
    }
    
    public FileWriter getArquivoItem() {
        return arquivoItem;
    }

    public void setArquivoItem(FileWriter arquivoItem) {
        this.arquivoItem = arquivoItem;
    }

}

    
