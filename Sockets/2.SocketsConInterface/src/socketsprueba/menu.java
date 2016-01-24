/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsprueba;

import com.cliente.Cliente;
import com.server.Server;
import javax.swing.JOptionPane;

/**
 *
 * @author jonatan
 */
public class menu {
    public menu(){
        int opcion=Integer.parseInt(JOptionPane.showInputDialog("1)Server\n2)Cliente"));
        Thread t;
        if(opcion==1){
            Server objs = new Server();
            objs.setVisible(true);
            t = new Thread(objs);
            t.start();
        }else if(opcion==2){
            Cliente objc = new Cliente();
            objc.setVisible(true);
            t = new Thread(objc);
            t.start();
        }
    }
}
