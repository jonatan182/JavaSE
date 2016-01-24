/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{
private ObjectOutputStream oos;
private ObjectInputStream ois;
private Socket s;
private String mensage;
private Scanner scaner;
private String escribir;
    public void run(){
        try{
            s = new Socket("127.0.0.1",9999);
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            readLine();
            close();
        }catch(Exception e){
            close();
        }
    }
    public void writeLine(){
        try{
            scaner = new Scanner(System.in);
            escribir = scaner.nextLine();
            oos.writeObject("Cliente Dice: "+escribir);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void readLine(){
        try {
            while(true){
                mensage = (String)ois.readObject();
                if(mensage != null && mensage instanceof String){
                    System.out.println(mensage);
                }
            }
        }catch (Exception  e) {
            e.getStackTrace();
        }
    }
    public void close(){
        try{
            ois.close();
            s.close();
            oos.close();
        }catch(Exception e){
        }
    }
    
}
