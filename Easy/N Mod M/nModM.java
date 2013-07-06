import java.io.*;
public class nModM {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			String[] numbers=line.split(",");
			int n=Integer.parseInt(numbers[0]);
			int m=Integer.parseInt(numbers[1]);
			while(n>=m){
				n-=m;
			}
			System.out.println(n);
		}
	}
}