package c428ah;

import java.io.*;
import java.net.*;
import java.util.Scanner;
  
public class Client1 
{
    final static int ServerPort = 888;
  
    public static void main(String args[]) throws UnknownHostException, IOException 
    {
        Scanner scanner = new Scanner(System.in);
          
        Socket socket = new Socket("localhost", 8888);
          
        DataInputStream beerkezo = new DataInputStream(socket.getInputStream());
        DataOutputStream kimeno = new DataOutputStream(socket.getOutputStream());
  
        Thread sendMessage = new Thread(new Runnable() 
        {
            @Override
            public void run() {
                while (true) {
  
                    String uzenet = scanner.nextLine();
                      
                    try {
                        kimeno.writeUTF(uzenet);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
          
        Thread readMessage = new Thread(new Runnable() 
        {
            @Override
            public void run() {
  
                while (true) {
                    try {
                        String uzenet = beerkezo.readUTF();
                        System.out.println(uzenet);
                    } catch (IOException e) {
  
                        e.printStackTrace();
                    }
                }
            }
        });
  
        sendMessage.start();
        readMessage.start();
  
    }
}

