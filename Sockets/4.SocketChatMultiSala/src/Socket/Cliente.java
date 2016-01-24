package Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Cliente implements Runnable {
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private sockeT w;
    private int puerto;
    private String ip;
    
    public Cliente(sockeT w,int puerto,String ip){
        this.w = w;
        this.puerto = puerto;
        this.ip = ip;
    }
    public void run() {
            try{
                s = new Socket(ip,puerto);
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());
                w.getAreaChat().append("Conexion Exitosa");
                this.readLine();
        }catch(Exception e){
            this.close();
            System.out.println("error"+e);
        }
    }
    public void writeLine(String linea){
        try {
            oos.writeObject("\nPerrisco: "+linea);
        } catch (IOException e) {
             e.printStackTrace();
        }
    }
    public void readLine(){
        try{
        while(true){
            Object aux = ois.readObject();
            if(aux != null && aux instanceof String)
                w.getAreaChat().append((String)(aux));
                Thread.sleep(15);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            oos.close();
            ois.close();
            s.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
