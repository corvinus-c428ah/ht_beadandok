package ht.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class titkositas {

    public static void main(String args[]) throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
    	PrintWriter pw = new PrintWriter("output.txt");
    	String tempLine;
    	char c;
    	String line = reader.readLine();
        while(line != null)
        {
        	tempLine = "";
            for (int i = 0; i < line.length(); i++) {
                c = line.charAt(i);
                if (c == 'z') {
					c = 'a';
				} else if (c == ' ') {
					c = ' ';
				} else {
	                c++;
				}

                tempLine += c;
            }
            pw.println(tempLine);
               line = reader.readLine();
        }
        reader.close();
        pw.close();
    }
}
