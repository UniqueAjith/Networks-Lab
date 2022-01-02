import java.io.*; 
import java.net.*;

public class HTTPwebclient{
	public static void main(String[] args){
		String hostName = "www.facebook.com"; 
		int portNumber = 80;
		try{
			Socket socket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
			BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.println("GET / HTTP/1.1\nHost: www.facebook.com\n\n"); 
			String inputLine;
			while ((inputLine = in.readLine()) != null){
				System.out.println(inputLine);
			}
		}
		catch (Exception e){
			System.err.println("Don't know about host " + hostName); 
			System.exit(1);
		}
	}
}