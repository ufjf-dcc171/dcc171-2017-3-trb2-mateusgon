package br.ufjf.dcc171;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ItemDAO {

    private static Scanner input;
    
    public ItemDAO() {
    }
    
    public void cria (ArrayList<Item> item) throws IOException
    {
        try {
            FileWriter fw = new FileWriter("item.txt", true);
            BufferedWriter conexao = new BufferedWriter(fw);
                for (Item q : item)
                {   
                    conexao.write(q.getNome()+ "//" + q.getTipoItem() + "//" + q.getValor() + "//");
                    conexao.newLine();
                }
            conexao.close();
        } catch (FileNotFoundException e) {
		e.printStackTrace();
        }
    }

    public ArrayList<Item> busca () throws IOException
    {
        ArrayList<Item> item = new ArrayList<>();               
        input = new Scanner (new FileReader("item.txt")).useDelimiter("//");
                try
                {
                    input.next();
                    while (input.hasNext())
                    {
                        Item a = new Item();
                        a.setNome(input.next());
                        a.setTipoItem(input.next());
                        a.setValor(input.nextDouble());
                        item.add(a);
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
        for (Item q : item)
                   System.out.println(q.getNome());
        return item;
    }
    
    public void altera ()
    {
    
    }        
     
    public void exclui (Item item)
    {
        
    }
    
    public Boolean vazio () throws IOException
    {
        try
            {
                Scanner input;               
                input = new Scanner ("item.txt");
                if ("Escrito//".equals(input.next()))
                {
                    input.close();
                    return false;
                }
                else
                {
                    input.close();
                    return true;
                }
            }catch (SecurityException securityException)
            {
                System.err.println("Write permission denied. Terminating.");
                System.exit(1);
            }
        return false;
    }
}
