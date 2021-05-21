package c428ah;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        
    	Scanner sc = new Scanner(System.in);

        try {
        	
        	ServerSocket serverSocket = new ServerSocket(8888);
        	Socket clientSocket = serverSocket.accept();
        	PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader in = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));

            Thread sender= new Thread(new Runnable() {
                String uzenet;
                @Override 
                public void run() {
                    while(true){
                        uzenet = sc.nextLine(); 
                        out.println(uzenet);   
                        out.flush();  
                    }
                }
            });
            sender.start();

            Thread receive= new Thread(new Runnable() {
                String uzenet ;
                @Override
                public void run() {
                    try {
                        uzenet = in.readLine();
                        while(uzenet!=null){
                            System.out.println("Kliens: "+ uzenet);
                            uzenet = in.readLine();
                        }

                        System.out.println("Kapcsolódási probléma!");

                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receive.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}                     

