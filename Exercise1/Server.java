
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class for implementing the server side of the code
 * 
 * It waits for the user input from the Client and returns a string representing if the entered string is palindrome or not
 * 
 * It runs until user inputs 'QUIT'
 * 
 * @author Sanyam, Neha
 *
 */
public class Server {

	/**
	 * aSocket is of type Socket that actually facilitates the communication
	 */
	private Socket aSocket;
	/**
	 * serverSocket creates a ServerSocket object, indicating a port number that is
	 * not used by other servers
	 */
	private ServerSocket serverSocket;
	/**
	 * socketOut is of type PrintWriter for providing the output to the socket
	 */
	private PrintWriter socketOut;
	/**
	 * socketIn is of type BufferedReader for reading from the Socket
	 */
	private BufferedReader socketIn;

	/**
	 * Constructs a constructor of class Server, which assigns the port number to
	 * the serverSocket.
	 */
	public Server() {
		try {
			serverSocket = new ServerSocket(8099);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * isPalindrome() reads the output from the socket, and checks if the read
	 * number is Palindrome or not.
	 * 
	 * After checking it writes the output to the socket.
	 */
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
				e.printStackTrace();
			} // reading from the client

		}
	}

	public static void main(String[] args) throws IOException {

		Server myServer = new Server();
		// establishing connection
		try {
			System.out.println("Server is now running");
			myServer.aSocket = myServer.serverSocket.accept();
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
