/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aboullaite;

import Socket.sockeT;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author mohammed
 */


// For every client's connection we call this class
public class clientThread extends Thread{
     private String clientName = null;
  private DataInputStream is = null;
  private PrintStream os = null;
  private Socket clientSocket = null;
  private final clientThread[] threads;
  private int maxClientsCount;

  public clientThread(Socket clientSocket, clientThread[] threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    maxClientsCount = threads.length;
  }

  public void run() {
    int maxClientsCount = this.maxClientsCount;
    clientThread[] threads = this.threads;

    try {
      /*
       * Create input and output streams for this client.
       */
      is = new DataInputStream(clientSocket.getInputStream());
      os = new PrintStream(clientSocket.getOutputStream());
      String name;
      while (true) {
        os.println("Ingresa Tu Nombre");
       
        name = is.readLine().trim();
        if (name.indexOf('@') == -1) {
          break;
        } else {
          os.println("El Nombre No Debe Contener El Caracter '@'");
        }
      }

      os.println("Bienvenido " + name
          + " ");
      synchronized (this) {
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null && threads[i] == this) {
            clientName = "@" + name;
            break;
          }
        }
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null && threads[i] != this) {
            threads[i].os.println("*** Un Nuevo Usuario " + name
                + " Ingreso A La Sala!!! ***");
          }
        }
      }
      /* Start the conversation. */
      while (true) {
        String line = is.readLine();
        if (line.startsWith("/Exit")) {
          break;
        }
    
        if (line.startsWith("@")) {
          String[] words = line.split("\\s", 2);
          if (words.length > 1 && words[1] != null) {
            words[1] = words[1].trim();
            if (!words[1].isEmpty()) {
              synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                  if (threads[i] != null && threads[i] != this
                      && threads[i].clientName != null
                      && threads[i].clientName.equals(words[0])) {
                    threads[i].os.println("<" + name + "> " + words[1]);
                   
                    this.os.println(">" + name + "> " + words[1]);
                    break;
                  }
                }
              }
            }
          }
        } else {
          synchronized (this) {
            for (int i = 0; i < maxClientsCount; i++) {
              if (threads[i] != null && threads[i].clientName != null) {
                threads[i].os.println("<" + name + "> " + line);
              }
            }
          }
        }
      }
      synchronized (this) {
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] != null && threads[i] != this
              && threads[i].clientName != null) {
            threads[i].os.println("*** El Usuario" + name
                + " Abandona La Sala ***");
          }
        }
      }
      os.println("*** Adios " + name + " ***");
      synchronized (this) {
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] == this) {
            threads[i] = null;
          }
        }
      }
      is.close();
      os.close();
      clientSocket.close();
      sockeT obj = new sockeT();
    } catch (IOException e) {
    }
  }
}
