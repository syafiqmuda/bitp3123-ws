package client.side;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket s = new Socket("localhost", 4999);
		String text = "Universiti Teknologi Malaysia Melaka";
		
		// Text view in client
		System.out.println(text);
		
		// Send to server
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println(wordcount(text));
		pr.flush();
		
		s.close();	
	}
	
	static int wordcount(String string)  
    {  
      int count=0;  
  
        char ch[]= new char[string.length()];     
        for(int i=0;i<string.length();i++)  
        {  
            ch[i]= string.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                count++;  
        }  
        return count;  
    }
}