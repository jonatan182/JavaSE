/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsininterface;

import com.cliente.Cliente;
import com.server.Server;
import java.util.Scanner;

/**
 *
 * @author jonatan
 */
public class SocketSinInterface {
    private static Scanner scaner;
    private static String escribir;
    public static void main(String[] args) {
        scaner = new Scanner(System.in);
        System.out.println("1.Server\n2.Cliente");
        escribir = scaner.nextLine();
        if(escribir.equals("1")){
            Server obj = new Server();
            Thread th = new Thread(obj);
            th.start();
            obj.writeLine();
        }else if(escribir.equals("2")){
            Cliente obj2 = new Cliente();
            Thread th = new Thread(obj2);
            th.start();
            obj2.writeLine();
        }
        
    }
}
