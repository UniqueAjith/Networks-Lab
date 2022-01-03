import java.io.*;
import java.net.*;

class FileClient{
	public static void main(String args[]) throws Exception{
		try{
			Socket sr = new Socket("LocalHost",1309);
			InputStream in = sr.getInputStream();
			FileOutputStream fs = new FileOutputStream("D:\\Download.java");
			byte[] b = new byte[30000];
			in.read(b,0,b.length);
			fs.write(b,0,b.length);
			System.out.println("Data Transfer Successfully");
			sr.close();
		}catch(Exception e){
			System.out.println("Error occur");
		}
	}
}