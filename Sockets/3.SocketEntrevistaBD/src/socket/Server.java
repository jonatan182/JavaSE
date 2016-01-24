/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import com.controller.controller;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import javax.swing.JOptionPane;
import java.net.Socket;

/**
 *
 * @author jonatan
 */

public class Server implements Runnable{
    private Socket s;
    private ServerSocket ss;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public void run() {
        try{
            ss = new ServerSocket(9994);
            s = ss.accept();
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            System.out.println("Conexion Exitosa");
            readLine();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }
    public void writeLine(String msg){
        try{
           controller obj = new controller();
           String mensage = obj.controll(msg);
           System.out.println(msg+"wroteLine server: "+mensage);
           oos.writeObject(mensage);
        }catch(Exception e){
        }
    }
    public void readLine(){
        
        String msg;
        try{
            while(true){
                Object aux = ois.readObject();
                if(aux != null && aux instanceof String){
                    msg = (String)aux;
                    
                    writeLine(msg);
                }
            }
        }catch(Exception e){
        }
    }
    
}
