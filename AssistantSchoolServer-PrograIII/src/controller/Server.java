package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private final static int PORT = 23575;
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public Server() throws IOException {
		serverSocket = new ServerSocket(PORT);
	}

	public void run() throws IOException {

		System.out.println("SERVIDOR");
		while (true) {
			clientSocket = serverSocket.accept();
			System.out.println("\nPuerto " + clientSocket.getPort());
			attend(clientSocket);
		}
	}
	

	
	public void attend(Socket socket) throws IOException {
		new ThreadClient(socket).start();
	}

	public static void main(String[] args) throws IOException {
		new Server().run();
	}

}
