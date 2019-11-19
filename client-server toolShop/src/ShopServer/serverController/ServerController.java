package ShopServer.serverController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import ShopServer.model.Shop;

/**
 * Provides data fields and methods to create a Java data-type, representing a
 * server in a java application.
 *
 * @author Y. Attia
 * @author H. Muhamad
 * @author Y. Khalil
 * @version 1.0
 * @since April 4th, 2019
 */

public class ServerController {
	PrintWriter out;
	Socket aSocket;
	ServerSocket serverSocket;
	BufferedReader in;
	Shop theShop;

	/**
	 * Constructs a Server with port 9898
	 */
	public ServerController(Shop aShop) {
		try {
			serverSocket = new ServerSocket(9898);
			System.out.println("Server is running");
			aSocket = serverSocket.accept();
			in = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			out = new PrintWriter((aSocket.getOutputStream()), true);
			theShop = aShop;

		} catch (IOException e) {
			System.out.println("Creating new socket error");
		}

	}

	/**
	 * Runs the Server
	 * 
	 * @throws IOException
	 */
	public void runServer() throws IOException {
		StringBuffer line = null;

		while (true) {
			line = new StringBuffer(in.readLine());
			if (line != null) {
				if (line.toString().startsWith("BUY")) {
					out.println("0" + theShop.buyItem(line.toString().substring(3, line.length())));

				} else if (line.toString().startsWith("LISTITEMS")) {
					out.println(theShop.listAllItems());
				} else if (line.toString().startsWith("LISTSUPPLIERS")) {
					out.println(theShop.listAllSuppliers());

				} else if (line.toString().startsWith("SEARCHID")) {
					out.println("0" + theShop.getItem(Integer.parseInt(line.toString().substring(8, line.length()))));
				} else if (line.toString().startsWith("SEARCHNAME")) {
					out.println("0" + theShop.getItem(line.toString().substring(10, line.length())));

				} else if (line.toString().startsWith("QUANTITY")) {
					out.println("0" + theShop.getItemQuantity(line.toString().substring(8, line.length())));

				} else if (line.toString().startsWith("PRINT")) {
					out.println(theShop.printOrder());

				}
			}

		}
	}

	/**
	 * Starts running the Server
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Shop aShop = new Shop();
		ServerController myServer = new ServerController(aShop);
		System.out.println("after accept");
		myServer.runServer();

	}
}
