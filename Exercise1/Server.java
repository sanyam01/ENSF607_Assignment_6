
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private Socket aSocket;
	private ServerSocket serverSocket;
	private PrintWriter socketOut;
	private BufferedReader socketIn;

	public Server() {
		try {
			serverSocket = new ServerSocket(8099);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void isPalindrome() {
		String line = null;
		while (true) {
			try {
				line = socketIn.readLine();
				if (line == null) {
					break;
				}
				// Pointers pointing to the beginning 
		        // and the end of the string 
		        int i = 0, j = line.length() - 1;
		        boolean flag = true;
		  
		        // While there are characters to compare 
		        while (i < j) { 
		  
		            // If there is a mismatch 
		            if (line.charAt(i) != line.charAt(j)) {
		            	socketOut.println(line + " is not palindrome"); 
		            	flag = false;
		            	break;
		            }
		  
		            // Increment first pointer and 
		            // decrement the other 
		            i++; 
		            j--; 
		        } 
		  
		        // Given string is a palindrome 
		        if (flag)
		        	socketOut.println(line + " is palindrome");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // reading from the client

		}
	}

	public static void main(String[] args) throws IOException {

		Server myServer = new Server();
		//establishing connection
		try {
			myServer.aSocket = myServer.serverSocket.accept();
			System.out.println("Server is now running");
			// for reading
			myServer.socketIn = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
			myServer.socketOut = new PrintWriter(myServer.aSocket.getOutputStream(), true);
			myServer.isPalindrome();
			
			myServer.socketIn.close();
			myServer.socketOut.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
