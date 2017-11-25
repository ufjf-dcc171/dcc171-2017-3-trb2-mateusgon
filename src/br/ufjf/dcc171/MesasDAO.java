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

    private Integer contador = 0;
    
    public MesasDAO() {

    }

    public void adicionar(List<Mesas> m, PedidoDAO p, ItemDoPedidoDAO idp) {
        try {
            FileWriter fw = new FileWriter("funcionamento.txt", false);
            BufferedWriter conexao = new BufferedWriter(fw);
            for (Mesas q : m) { //diretorio.getArquivoFuncionamento
                List<Pedido> pedido = q.getPedidos();
                conexao.write(q.getNome() + "//" + q.getNumero() + "//" + q.getPedidos().size()+"//");
                conexao.newLine();
                p.adicionar(pedido, conexao, idp);
            }
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Mesas> buscar(PedidoDAO pedido, ItemDoPedidoDAO idp) throws FileNotFoundException {
        ArrayList<Mesas> m = new ArrayList<>();
        Scanner input = new Scanner(new FileReader("funcionamento.txt")).useDelimiter("//");
        try {
            while (input.hasNext()) {
                Mesas me = new Mesas(input.next(), input.nextInt());
                m.add(me);
                int c = input.nextInt();
                if (c > 0)
                {
                    me.setPedidos(pedido.buscar(idp, input, c));
                }
            }
       } catch (NoSuchElementException elementException) {
            System.out.println("Todas as leituras feitas.");
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
        }
        input.close();
        return m;
    }
}
