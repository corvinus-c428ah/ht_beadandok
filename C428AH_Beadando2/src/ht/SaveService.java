package ht;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SaveService implements Runnable{
	private Socket s;
	
	public SaveService(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		BufferedReader reader;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date d = new Date();
		try {
			reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String text = reader.readLine();
			
			PrintWriter output = new PrintWriter(new FileWriter("data.txt", true));
			output.println(formatter.format(d)+": "+text);
			output.flush();
			output.close();
			reader.close();
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}