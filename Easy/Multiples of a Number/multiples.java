import java.io.*;

public class multiples {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String[] numbers;
		while ((line = in.readLine()) != null){	
			numbers=line.split(",");
			int first=Integer.parseInt(numbers[0]);
			int second=Integer.parseInt(numbers[1]);
			int result=second;
			while(first>result)
				result+=second;
			System.out.println(result);
		}
	}
}
