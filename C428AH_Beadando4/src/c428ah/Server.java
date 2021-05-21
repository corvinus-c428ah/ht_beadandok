package c428ah;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server 
{
  
    static Vector<ClientHandler> kliensek = new Vector<>();
    static int i = 0;
  
    public static void main(String[] args) throws IOException 
    {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket;
          
        while (true) 
        {
        	socket = serverSocket.accept();
  
            DataInputStream beerkezo = new DataInputStream(socket.getInputStream());
            DataOutputStream kimeno = new DataOutputStream(socket.getOutputStream());
              
            ClientHandler mtch = new ClientHandler(socket,"kliens " + i, beerkezo, kimeno);
  
            Thread thread = new Thread(mtch);
              
            kliensek.add(mtch);
  
  			thread.start();
            i++;
  
        }
    }
}
