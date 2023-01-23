package FirstSocketProgramming;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOne {
	public static void main(String[] args) {
		try {
			System.out.println("Waiting for clients...");
			ServerSocket ss = new ServerSocket(9807);
			Socket soc =ss.accept();
			System.out.println("Connection established");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
