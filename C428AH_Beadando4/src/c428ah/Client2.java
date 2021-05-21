package c428ah;

import java.io.*;
import java.net.*;
import java.util.Scanner;
  
public class Client2 
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
  
                    // read the message to deliver.
                    String msg = scanner.nextLine();
                      
                    try {
                        kimeno.writeUTF(msg);
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
                        String msg = beerkezo.readUTF();
                        System.out.println(msg);
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

