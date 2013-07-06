import java.io.*;

public class armstrongNumbers{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			int num=Integer.parseInt(line);
			int power=line.length();
			int sum=0;
			for(int i=0;i<line.length();i++)
				sum+=Math.pow(Character.getNumericValue(line.charAt(i)), power);
			if(sum==num)
				System.out.println("True");
			else
				System.out.println("False");
		}
	}
}