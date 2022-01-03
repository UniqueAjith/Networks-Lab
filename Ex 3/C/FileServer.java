import java.io.*;
import java.net.*;

class FileServer{
	public static void main(String args[]) throws Exception{
		try{
			ServerSocket s = new ServerSocket(1309);
			Socket sr = s.accept();
			System.out.println("Connection Accepted..");
			FileInputStream fs = new FileInputStream("C:\\number.java");
			byte[] b = new byte[3000];
			fs.read(b,0,b.length);
			OutputStream os = sr.getOutputStream();
			System.out.println("Done");
			s.close();
		}catch(Exception e){
			System.out.println("Error Occur");
		}
	}
}