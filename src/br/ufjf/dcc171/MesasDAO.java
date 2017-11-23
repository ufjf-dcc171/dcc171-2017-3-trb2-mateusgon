package br.ufjf.dcc171;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MesasDAO {

    private Integer contador=0;
    
    public MesasDAO() {
        
    }

    public void adicionar (List<Mesas> m)
    {
        try {
                for (Mesas q : m)
                {
                    FileWriter fw = new FileWriter("funcionamento.txt", true);
                    BufferedWriter conexao = new BufferedWriter(fw);
                    conexao.write(q.getNome() + "//");
                    conexao.newLine();
                    conexao.close();
                }
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
                        Mesas me = new Mesas(input.next(), contador);
                        contador++;
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