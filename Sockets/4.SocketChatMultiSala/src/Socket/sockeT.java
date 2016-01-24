package Socket;


import Socket.Servidor;
import Socket.Cliente;
import aboullaite.ClientServer;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class sockeT extends JFrame implements ActionListener, WindowListener, KeyListener{
    private Servidor s;
    private Cliente c;
    private JMenuBar menuBar;
    private JMenu accion;
    private JMenuItem conect, create, exit, crearSala, unirseSala;
    public JTextArea areaChat;
    private int a;
    private String ip;
  
    public JTextArea getAreaChat(){
        return areaChat;
    }
    private JTextField text;
    private JButton send;
    private JScrollPane scroll;
    private GridBagConstraints gbc;

    public sockeT(){
        menuBar = new JMenuBar();
        accion = new JMenu("Accion");
        conect = new JMenuItem("Conectar");
        create = new JMenuItem("Crear Servidor");
        crearSala = new JMenuItem("Crear Sala");
        unirseSala = new JMenuItem("Ingresar A Sala");
        exit = new JMenuItem("Salir");
        areaChat = new JTextArea();
        scroll = new JScrollPane(areaChat);
        gbc = new GridBagConstraints();
        text = new JTextField(20);
        send = new JButton("Enviar");
        definirVentana();
    }
    public void definirVentana(){
        conect.addActionListener(this);
        crearSala.addActionListener(this);
        unirseSala.addActionListener(this);
        create.addActionListener(this);
        exit.addActionListener(this);
        send .addActionListener(this);
        text.addKeyListener(this);
        this.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(scroll,gbc);
   
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        this.add(text,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        this.add(send,gbc);
        
        menuBar.add(accion);
        accion.add(conect);
        accion.add(create);
        accion.add(crearSala);
        accion.add(unirseSala);
        accion.add(exit);
        
        this.setName("Chat");
        this.setSize(400,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(menuBar);
        this.addWindowListener(this);
        this.setVisible(true);
    }



    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==create){
            a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese El Puerto"));
            if(a!=0){
            s = new Servidor(this,a);
            Thread t = new Thread(s);
            t.start();
            }
        }else if(ae.getSource()==conect){
            a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese El Puerto"));
            ip = JOptionPane.showInputDialog("Ingrese La Ip");
            if((a!=0)&&(ip!="")){
            c = new Cliente(this,a,ip);
            Thread t = new Thread(c); 
            t.start();
            }
        }else if(ae.getSource()== exit){
            this.dispose();
        }else if(ae.getSource()== send){
            if(s!=null){
                s.writeLine(text.getText());
                areaChat.append("\nYO: "+text.getText());
                text.setText("");
            }
            if(c!=null){
                c.writeLine(text.getText());
                areaChat.append("\nYO: "+text.getText());
                text.setText("");
            }
        }else if(ae.getSource()== crearSala){
            
            ClientServer  obj = new ClientServer();
            this.dispose();
        }
    }

  
    public void windowClosed(WindowEvent e) {
        if(s!=null){
           
        }
        
    }

    @Override
    public void windowOpened(WindowEvent we) {
        
    }

    @Override
    public void windowClosing(WindowEvent we) {
      
    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
      
    }

    @Override
    public void windowActivated(WindowEvent we) {
     
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }

    public void keyTyped(KeyEvent ke) {
        
    }
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()){
                case KeyEvent.VK_ENTER:
                    if(s!=null){
                        s.writeLine(text.getText());
                        areaChat.append("\nYO: "+text.getText());
                        text.setText("");
                    }
                    if(c!=null){
                        c.writeLine(text.getText());
                        areaChat.append("\nYO: "+text.getText());
                        text.setText("");
                    }
               }
    }

  
    public void keyReleased(KeyEvent ke) {
       
    }
}

 
