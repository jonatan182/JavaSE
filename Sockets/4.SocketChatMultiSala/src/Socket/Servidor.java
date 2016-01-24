package Socket;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Servidor implements Runnable {
    private ServerSocket ss;
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private sockeT w;    
    private int a;
    public Servidor(sockeT w,int puerto){
        this.w = w;
        this.a = puerto;
    }
    public void run() {
            try{
            ss = new ServerSocket(a);
            s = ss.accept();
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            w.getAreaChat().append("Conexion Exitosa");
            this.readLine();
        }catch(Exception e){
            this.closeServer();
            e.printStackTrace();
        }
    }
    public void writeLine(String linea){
        try {
            oos.writeObject("\nJonatan: "+linea);
        } catch (IOException e) {
             e.printStackTrace();
        }
    }
    public void readLine(){
        try{
        while(true){
            Object aux = ois.readObject();
            if(aux != null && aux instanceof String)
                w.getAreaChat().append((String)aux);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void closeServer(){
        try {
            oos.close();
            ois.close();
            s.close();
            ss.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
