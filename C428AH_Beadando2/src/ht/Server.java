package ht;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSock = new ServerSocket(2020);
		
		while(true) {
			new Thread(new SaveService(serverSock.accept())).start();
		}
	}

}