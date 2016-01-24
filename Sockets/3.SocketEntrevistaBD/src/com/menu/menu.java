/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu;

import com.gui.GuiCliente;
import javax.swing.JOptionPane;
import socket.Server;

/**
 *
 * @author jonatan
 */
public class menu {
    public menu(){
        int x = Integer.parseInt(JOptionPane.showInputDialog("1)Cliente\n2)Server"));
        switch(x){
            case 1:
                GuiCliente obj = new GuiCliente();
                obj.setVisible(true);
                obj.setLocationRelativeTo(null);
                break;
            case 2:
                Server obj2 = new Server();
                Thread t = new Thread(obj2);
                t.start();
                
        }
    }
}
