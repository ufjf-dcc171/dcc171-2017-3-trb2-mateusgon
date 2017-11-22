package br.ufjf.dcc171;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ItemDAO {

    private static Scanner input;
    private String endereco;
    private Formatter output;
    
    public ItemDAO(String enderecoItem) {
        this.endereco = enderecoItem;
    }
    
    public void cria (ArrayList<Item> item)
    {
        try
            {
                output = new Formatter(endereco); 
                output.format("Escrito// %n");
                for (Item q : item)
                    output.format("%s//%s//%.2f//%n", q.getNome(), q.getTipoItem(), q.getValor());
                output.close();
            }
        catch (SecurityException securityException)
            {
                System.err.println("Write permission denied. Terminating.");
                System.exit(1); // termina o programa
            }
        catch (FileNotFoundException fileNotFoundException)
              {
              System.err.println("Error opening file. Terminating.");
              System.exit(1); // termina o programa
              }
    }

    public ArrayList<Item> busca () throws IOException
    {
        ArrayList<Item> item = new ArrayList<>();               
        input = new Scanner (new FileReader(endereco)).useDelimiter("//");
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
                input = new Scanner (Paths.get(endereco));
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
            }
        catch (SecurityException securityException)
            {
                System.err.println("Write permission denied. Terminating.");
                System.exit(1); // termina o programa
            }
        catch (FileNotFoundException fileNotFoundException)
              {
              System.err.println("Error opening file. Terminating.");
              System.exit(1); // termina o programa
              }
        return false;
    }
}
