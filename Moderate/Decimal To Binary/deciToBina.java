import java.io.*;

public class deciToBina{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		int num;
		String binary;
		while ((line = in.readLine()) != null){	
			binary="0";
			num=Integer.parseInt(line);
			while(num>0){
				if(num%2!=0){
					binary="1"+binary.substring(1);
					num--;
				}
				else{
					binary="0"+binary;
					num/=2;
				}
			}
			System.out.println(binary);
		}
	}
}
