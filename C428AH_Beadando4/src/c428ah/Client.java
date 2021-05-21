package c428ah;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        try {
            Socket clientSocket = new Socket("localhost",8888);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Thread sender = new Thread(new Runnable() {
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
            Thread receiver = new Thread(new Runnable() {
                String uzenet;
                @Override
                public void run() {
                    try {
                        uzenet = in.readLine();
                        while(uzenet!=null){
                            System.out.println("Szerver : "+ uzenet);
                            uzenet = in.readLine();
                        }
                        System.out.println("Szerver nem elérhetõ");
                        out.close();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receiver .start();
    }catch (IOException e){
        e.printStackTrace();
        }
    }
}
