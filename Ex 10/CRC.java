import java.io.*;

public class CRC{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Generator:");
		String gen = br.readLine();
		System.out.println("Enter Date:");
		String data = br.readLine();
		String code = data;
		while(code.length()<(data.length() + gen.length() - 1)){
			code = code + "0";
			code = data + div(code,gen);
		}
		System.out.println("Transmitted code:"+code);
		System.out.println("Received Code:");
		String rec = br.readLine();
		if(Integer.parseInt(div(rec,gen))==0){
			System.out.println("No Error");
		}
		else{
			System.out.println("Error");
		}
	}

	static String div(String num1,String num2){
		int pointer = num2.length();
		String result = num1.substring(0,pointer);
		String remainder ="";
		for(int i=0;i<num2.length();i++){
			if(result.charAt(i)==num2.charAt(i)){
				remainder += "0"; 
			}
			else{
				remainder += "1";
			}
		}
		while(pointer<num1.length()){
			if(remainder.charAt(0)=="0"){
				remainder = remainder.substring(1,remainder.length());
				remainder = remainder + String.valueOf(num1.charAt(pointer));
				pointer++;
			}
			result = remainder;
			remainder ="";
			for(int i=0;i<num2.length();i++){
				if(result.charAt(i)==num2.charAt(i)){
					remainder += "0"; 
				}
				else{
					remainder += "1";
				}
			}
		}
		return remainder.substring(1,remainder.length());
	}
}