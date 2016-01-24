/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import com.gui.GuiCliente;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import java.net.Socket;
/**
 *
 * @author jonatan
 */
public class Cliente implements Runnable{
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private GuiCliente o;
    public Cliente(GuiCliente obj){
        this.o = obj;
    }
    public void run(){
        try{
            s = new Socket("localhost",9994);
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            System.out.println("Conexcion Exitosa");
            readLine();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
    }
    public void writeLine(String mensage){
        try{
            oos.writeObject((String)mensage);
        }catch(Exception e){
        }
    }
    public void readLine(){
        try{
            Object aux;
            String mensage;
            while(true){
                aux = ois.readObject();
                if(aux != null && aux instanceof String){
                    mensage = (String)aux;
                    o.getjTextField2().setText(mensage);
                    System.out.println(mensage);
                }
            }
        }catch(Exception e){
        }
    }
    
    
}
