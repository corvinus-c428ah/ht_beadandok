package c428ah;

import java.io.*;
import java.util.*;
import java.net.*;


public class ClientHandler implements Runnable 
    {
        Scanner scn = new Scanner(System.in);
        private String nev;
        final DataInputStream beerkezo;
        final DataOutputStream kimeno;
        Socket socket;

        public ClientHandler(Socket s, String nev,
                                DataInputStream beerkezo, DataOutputStream kimeno) {
            this.beerkezo = beerkezo;
            this.kimeno = kimeno;
            this.nev = nev;
            this.socket = s;
        }
      
        @Override
        public void run() {      
            String uzenet;

            while (true) 
            {
                try
                {
                    uzenet = beerkezo.readUTF();
                       
                    for (ClientHandler mc : Server.kliensek) 
                    {
                            mc.kimeno.writeUTF(this.nev+": "+uzenet);
                            break;
                    }
                } catch (IOException e) {
                      
                    e.printStackTrace();
                }     
            }           
        }    
    }


