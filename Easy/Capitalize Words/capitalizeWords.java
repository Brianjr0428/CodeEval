import java.io.*;

public class capitalizeWords{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){
			for(int i=0;i<line.length();i++){
				if(line.charAt(i)>=97&&line.charAt(i)<=122){
					if(i==0||line.charAt(i-1)==' ')
						System.out.print((char)(line.charAt(i)-32));
					else
						System.out.print(line.charAt(i));
				}
				else
					System.out.print(line.charAt(i));
			}
			System.out.println();
		}
	}
}