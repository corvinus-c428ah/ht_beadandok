package ht;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("localhost", 2021);
		String text = "Example";
		
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.print(text);
		pw.flush();
		pw.close();
		socket.close();

	}

}