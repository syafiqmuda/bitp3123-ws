package client.side;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket("localhost", 4999);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("Whatzuppp");
		pr.flush();
		
		s.close();
	}
}