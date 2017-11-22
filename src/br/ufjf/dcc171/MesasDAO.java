package br.ufjf.dcc171;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MesasDAO {

    private String endereco;
    
    public MesasDAO(String enderecoMesas) {
        endereco = enderecoMesas;
    }

    public void criar ()
    {
    
    }

    public void adicionar (Mesas m)
    {
        try {
		FileWriter fw = new FileWriter(endereco, true);
		BufferedWriter conexao = new BufferedWriter(fw);
                conexao.write(m.getNome() + "//");
		conexao.newLine();
		conexao.close();
        } catch (Exception e) {
		e.printStackTrace();
        }
    }

    public ArrayList<Mesas> buscar () throws FileNotFoundException
    {
        ArrayList <Mesas> m = new ArrayList<>();
        Mesas a = new Mesas("Mesa 0", 0);
        m.add(a);
        Scanner input = new Scanner (new FileReader(endereco)).useDelimiter("//");
                try
                {
                    while (input.hasNext())
                    {
                        Mesas me = new Mesas();
                        me.setNome(input.next());
                        m.add(me);
                        System.out.println(me);
                    }
                }
                catch (NoSuchElementException elementException)
                {
                  System.err.println("File improperly formed. Terminating.");
                }
                catch (IllegalStateException stateException)
                {
                   System.err.println("Error reading from file. Terminating.");
                } 
        input.close();
        return m;
    }

    public void excluir ()
    {
    
    }
    
}
