package FirstSocketProgramming;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientOne {
	public static void main(String[] args) {
		System.out.println("Client started");
		try {
			Socket soc = new Socket("localhost",9807);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
