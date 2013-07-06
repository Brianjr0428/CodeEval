import java.io.*;

public class evenNumbers{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			int number;
			while ((line = in.readLine()) != null){	
				number=Integer.parseInt(line);
				if(number%2==0)
					System.out.println("1");
				else
					System.out.println("0");
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
