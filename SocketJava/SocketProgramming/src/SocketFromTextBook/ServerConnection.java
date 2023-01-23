package SocketFromTextBook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerConnection {
	public static void main(String[] args) {
		doClientConnection("DeDee", 1980);
	}
	
	public static void doClientConnection(String computerName, int serverPort) {
		Socket connection;
		InputStream in;
		OutputStream out;
		try {
			connection = new Socket(computerName, serverPort);
			in = connection.getInputStream();
			out = connection.getOutputStream();
		}
		catch(IOException e) {
			System.out.println("Attempt to create connection failed with error " + e);
			return;
		}
		
		try{
			connection.close();
		}
		catch(IOException e) {
			
		}
	}
}
