package ChatServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	final static int DEFAULT_PORT = 1728;      //Listening port
	final static String HANDSHAKE = "CLChat";  //Handshake string
	final static char MESSAGE = '0';           //To start chat
	static final char CLOSE = '1';             //To quit chat
	
	public static void main(String[] arg) {
		int port;
		ServerSocket listener;
		Socket connection;        //For communication with the client
		BufferedReader incoming;  //Stream for receiving data from client
		PrintWriter outgoing;     //Stream for sending data to client
		String messageOut;        //A message to be sent to the client
		String messageIn;         //A message received from the client
		Scanner userInput;          
		
		if(arg.length == 0) {
			port = DEFAULT_PORT;
		}
		else {
			try {
				port = Integer.parseInt(arg[0]);
				if(port < 0 || port > 65535) {
					throw new NumberFormatException();
				}
			} catch(NumberFormatException e) {
				System.out.println("Illegal port number, " + arg[0]);
				return;
			}
		}
		
		/* Wait for a connection request. When it arrives, close down the listener
		   Create streams for communication and exchange the handshake. */
		try {
			listener = new ServerSocket(port);
			System.out.println("Listening on port " + listener.getLocalPort());
			connection = listener.accept();
			incoming = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			outgoing = new PrintWriter(connection.getOutputStream());
			outgoing.println(HANDSHAKE);
			outgoing.flush();
			messageIn = incoming.readLine();
			if(! HANDSHAKE.equals(messageIn)) {
				throw new Exception("Connected program is not a CLChat! ");
			}
			System.out.println("Connected. Waiting for the first message");
		}
		catch(Exception e) {
			System.out.println("An error occureed with opening connection");
			System.out.println(e.toString());
			return;
		}
		
		/* Exchange message with the other end of the connection until one side
		 * or the other closes the connection. This server program waits for the
		 * first message from the client. After that, message alternate strictly 
		 * back and forth
		 */
		
		try {
			userInput = new Scanner(System.in);
			while(true) {
				System.out.println("Waiting....");
				messageIn = incoming.readLine();
				if(messageIn.length() > 0) {
					if(messageIn.charAt(0) == CLOSE) {
						System.out.println("Connection closed at other end. ");
						connection.close();
						break;
					}
					messageIn = messageIn.substring(1);
				}
				System.out.println("Received: " + messageIn);
				System.out.println("Send: ");
				messageOut = userInput.nextLine();
				if(messageOut.equalsIgnoreCase("quit")) {
					outgoing.println(CLOSE);
					outgoing.flush();
					System.out.println("Connection closed.");
					break;
				}
				outgoing.println(MESSAGE + messageOut);
				outgoing.flush();
				if(outgoing.checkError()) {
					throw new IOException("Error occurred while transmitting message");
				}
			}
		}
		catch(Exception e) {
			System.out.println("Sorry, an error has occurred. Connection lost.");
			System.out.println("Error " + e);
			System.exit(1);
		}
	}
}
