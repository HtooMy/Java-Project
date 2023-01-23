package DateServer;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	public static final int LISTENING_PORT = 32007;
	
	public static void main(String[] args) {
		ServerSocket listener;
		Socket connection;
		try {
			listener = new ServerSocket(LISTENING_PORT);
			System.out.println("Listening on port" + LISTENING_PORT);
			while(true) {
				connection = listener.accept();
				sendData(connection);
			}
		}
		catch(Exception e) {
			System.out.println("Sorry, the server has shut down");
			System.out.println("Error: " + e);
			return;
		}
	}
	
	private static void sendData(Socket client) {
		try {
			System.out.println("Connection from " + client.getInetAddress().toString());
			Date now = new Date();   //Current date and time
			PrintWriter outgoing;    //Stream for sending data
			outgoing = new PrintWriter (client.getOutputStream());
			outgoing.println(now.toString());
			outgoing.flush();        //Make sure the data is actually sent!
			client.close();
		}
		catch(Exception e) {
			System.out.println("Error " + e);
		}
	}
}
