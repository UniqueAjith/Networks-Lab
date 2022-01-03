import java.io.*;
import java.net.*;
import java.util.*;
class Client{
	public static void main(String args[]){
		try{
			DatagramSocket client=new DatagramSocket();

			byte[] sendbyte=new byte[1024];
			InetAddress addr=InetAddress.getByName("127.0.0.1");
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the Physical address (MAC) or IP Address:");
			String str=in.readLine();
			sendbyte=str.getBytes();
			DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,1309);
			client.send(sender);

			byte[] receivebyte=new byte[1024];
			DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
			client.receive(receiver);

			String s=new String(receiver.getData()); 
			System.out.println("The Logical Address is(IP) or MAC Address: "+s.trim());

			client.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
