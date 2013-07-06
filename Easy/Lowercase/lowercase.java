import java.io.*;

public class lowercase{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			while ((line = in.readLine()) != null){	
				for(int i=0;i<line.length();i++){
					if(line.charAt(i)>=65&&line.charAt(i)<=90)
						System.out.print((char)(line.charAt(i)+32));
					else
						System.out.print(line.charAt(i));
				}
				System.out.println();
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
