package br.ufjf.dcc171;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JOptionPane;

public class Diretorio {

    private File diretorio = new File("C:\\Users\\Mateus G\\Desktop\\Pizzaria - Petini");
    private FileWriter arquivoMesa;
    private FileWriter arquivoPedido;
    private FileWriter arquivoItemDoPedido;
    private FileWriter arquivoItem;
    private Boolean existe = false;

    public Diretorio() {
        Path path = diretorio.toPath();
        if (!Files.exists(path))
        {
            try {
                diretorio.mkdir();
                arquivoMesa = new FileWriter("C:\\Users\\Mateus G\\Desktop\\Pizzaria - Petini\\mesas.txt");
                arquivoPedido = new FileWriter("C:\\Users\\Mateus G\\Desktop\\Pizzaria - Petini\\pedidos.txt");
                arquivoItemDoPedido = new FileWriter("C:\\Users\\Mateus G\\Desktop\\Pizzaria - Petini\\itensdospedidos.txt");
                arquivoItem = new FileWriter("C:\\Users\\Mateus G\\Desktop\\Pizzaria - Petini\\item.txt");            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
                System.out.println(ex);
            }
        }
        else
        {
            this.existe = true;
        }
        
    }
    
    public File getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(File diretorio) {
        this.diretorio = diretorio;
    }

    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean existe) {
        this.existe = existe;
    }

    public FileWriter getArquivoMesa() {
        return arquivoMesa;
    }

    public void setArquivoMesa(FileWriter arquivoMesa) {
        this.arquivoMesa = arquivoMesa;
    }

    public FileWriter getArquivoPedido() {
        return arquivoPedido;
    }

    public void setArquivoPedido(FileWriter arquivoPedido) {
        this.arquivoPedido = arquivoPedido;
    }

    public FileWriter getArquivoItemDoPedido() {
        return arquivoItemDoPedido;
    }

    public void setArquivoItemDoPedido(FileWriter arquivoItemDoPedido) {
        this.arquivoItemDoPedido = arquivoItemDoPedido;
    }

    public FileWriter getArquivoItem() {
        return arquivoItem;
    }

    public void setArquivoItem(FileWriter arquivoItem) {
        this.arquivoItem = arquivoItem;
    }
    
    
}

    
