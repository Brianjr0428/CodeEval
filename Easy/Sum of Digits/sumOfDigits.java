import java.io.*;

public class sumOfDigits{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null){	
				int sum=0;
				for(int i=0;i<line.length();i++)
					sum+=Character.getNumericValue(line.charAt(i));
				System.out.println(sum);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
