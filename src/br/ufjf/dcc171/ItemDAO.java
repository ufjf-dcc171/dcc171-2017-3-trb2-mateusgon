package br.ufjf.dcc171;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ItemDAO {

    private static Scanner input;
    private File arquivo = new File("item.txt");
    
    public ItemDAO() {
    }
    
    public void cria (ArrayList<Item> item) throws IOException
    {
        try {
            FileWriter fw = new FileWriter("item.txt", false);
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
        input.useLocale(Locale.ENGLISH);
            try
                {
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
                  System.out.println("Todas as leituras de item foram feitas.");
                }
                catch (IllegalStateException stateException)
                {
                   System.err.println("Error reading from file. Terminating.");
                } 
        input.close();
        return item;
    }
    
    public void altera ()
    {
    
    }        
     
    public Boolean vazio () throws IOException
    {
        try
            {
                Scanner input;               
                input = new Scanner ("item.txt");
                if (arquivo.exists() && arquivo.length() != 0)
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
