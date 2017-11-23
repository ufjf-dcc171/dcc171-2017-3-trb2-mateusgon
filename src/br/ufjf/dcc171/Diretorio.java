package br.ufjf.dcc171;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JOptionPane;

public class Diretorio {

    private FileWriter arquivoFuncionamento;
    private FileWriter arquivoItem;
    private Boolean existe = false;

    public Diretorio() {
            try {
                arquivoFuncionamento = new FileWriter("funcionamento.txt");    
                arquivoItem = new FileWriter("item.txt");    
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            }
        }
   
    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean existe) {
        this.existe = existe;
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

    
