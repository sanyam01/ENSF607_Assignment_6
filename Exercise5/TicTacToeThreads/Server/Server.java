package Server;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Server.Game;

public class Server implements Constants {
	// X sockets
	private Socket xSocket;

	// O sockets
	private Socket oSocket;

	// Printwriter for Xplayers and OPlayers to write messages
	private PrintWriter xSocketOut;

	private ServerSocket serverSocket;
	private ExecutorService pool;
	//private Board theBoard;

	public Server() {
		try {
			// Server socket accepts the port as a parameter
			serverSocket = new ServerSocket(9090);
			// System.out.println("Server is running!");
			pool = Executors.newFixedThreadPool(20);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runServer() {
		// Accepting the fist connection as the x-Player and second connection as
		// o-Player
		try {
			while (true) {
				xSocket = serverSocket.accept();
				System.out.println("Accepted xPlayer");
				xSocketOut = new PrintWriter(xSocket.getOutputStream(), true);

				//We need to send one message to the X player until O player joins
				xSocketOut.println("6," + "Waiting for other player to connect..");

				oSocket = serverSocket.accept();
				System.out.println("Accepted oPlayer");
				//theBoard = new Board();

				Game theGame = new Game(xSocket, oSocket);
				pool.execute(theGame);
			}

		}catch (SocketException e) {
			System.out.println("Socket exception!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		Server myServer = new Server();
		System.out.println("Server is running..");
		myServer.runServer();
	}

}