package server.side;

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(4999);
		
			Socket s = ss.accept();
			
			 System.out.println(" The Client" + " " + s.getInetAddress()
             + ":" + s.getPort() + " IS CONNECTED ");
			 
			 InputStreamReader in = new InputStreamReader(s.getInputStream());
			 BufferedReader bf = new BufferedReader(in);
			 
			 String str = bf.readLine();
			 System.out.println("From Client : " + str);
			 
			 ss.close();
	}
}
