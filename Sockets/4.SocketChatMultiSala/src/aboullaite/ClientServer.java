package aboullaite;

import javax.swing.*;

//Class to precise who is connected : Client or Server
public class ClientServer {

	
	public  ClientServer(){
		
		Object[] selectioValues = { "Server","Client"};
		String initialSection = "Server";
		
		Object selection = JOptionPane.showInputDialog(null, "Opciones : ", "Chat Corporativo", JOptionPane.QUESTION_MESSAGE, null, selectioValues, initialSection);
		if(selection.equals("Server")){
                   String[] arguments = new String[] {};
			new MultiThreadChatServerSync(arguments);
                        
		}else if(selection.equals("Client")){
			String IPServer = JOptionPane.showInputDialog("Ingresa El  IP Del Servidor");
                        String[] arguments = new String[] {IPServer};
			new ChatClient(arguments);
		}
		
	}

}
