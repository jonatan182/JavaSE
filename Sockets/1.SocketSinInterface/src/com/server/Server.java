/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable{
    private ServerSocket ss;
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String mensage;
    private Scanner scaner;
    private String escribir;
    public void run(){
        try{
            ss = new ServerSocket(9999);
            s = ss.accept();
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            readLine();
            cerrar();
        }catch(Exception e){
            e.getStackTrace();
            cerrar();
        }
    }
    public void cerrar(){
        try{
            ois.close();
            oos.close();
            s.close();
            ss.close();
        }catch(Exception e){
            e.getStackTrace();
            
        }
    }
    public void writeLine(){
        try{
            scaner = new Scanner(System.in);
            escribir = scaner.nextLine();
            oos.writeObject("Server Dice:"+escribir);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void readLine(){
        try{
            while(true){
                mensage =(String)ois.readObject();
                if(mensage !=null && mensage instanceof String){
                    System.out.println(mensage);
                }
            }
        }catch(Exception e){
            e.getStackTrace();
        }
    }
    
}
