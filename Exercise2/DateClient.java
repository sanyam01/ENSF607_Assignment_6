
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * DateClient represents the client side of the code.
 * 
 * It gets the input from the user as either 'Date' or 'Time' and returns the current date or current time
 * 
 * 'QUIT' input breaks the client server connection
 * 
 * @author Sanyam, Neha
 *
 */
public class DateClient {
	/**
	 * socketOut is of type PrintWriter for providing the output to the socket
	 */
	private PrintWriter socketOut;
	/**
	 * palinSocket is of type Socket that actually facilitates the communication
	 */
	private Socket palinSocket;
	/**
	 * stdin is of type BufferedReader for getting input from the user
	 */
	private BufferedReader stdIn;
	/**
	 * socketIn is of type BufferedReader for getting input from the socket
	 */
	private BufferedReader socketIn;

	/**
	 * DateClient(String serverName, int portNumber) constructs the constructor of class DateClient
	 * 
	 * @param serverName represents the server which is local host here
	 * @param portNumber represents the port number related to the specific client-server code
	 */
	public DateClient(String serverName, int portNumber) {
		try {
			palinSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(
					palinSocket.getInputStream()));
			socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	/**
	 * communicate() reads the user input and sends it to the server using the socket
	 * 
	 * The returned output by the server is then printed on the console
	 */
	public void communicate()  {

		String line = "";
		String response = "";
		boolean running = true;
		while (running) {
			try {
				System.out.println("Please select an option (DATE/TIME)");
				line = stdIn.readLine();
				if (!line.equals("QUIT")){
					socketOut.println(line);
					response = socketIn.readLine();
					System.out.println(response);	
				}else{
					socketOut.println(line);
					running = false;
				}
				
			} catch (IOException e) {
				System.out.println("Sending error: " + e.getMessage());
			}
		}
		try {
			stdIn.close();
			socketIn.close();
			socketOut.close();
		} catch (IOException e) {
			System.out.println("Closing error: " + e.getMessage());
		}

	}

	public static void main(String[] args) throws IOException  {
		DateClient aClient = new DateClient("localhost", 9090);
		aClient.communicate();
	}
}