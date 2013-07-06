import java.io.*;

public class calculateDistance{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			String[] numbers=line.split(" ");
			int onex=Integer.parseInt(numbers[0].substring(1,numbers[0].length()-1));
			int oney=Integer.parseInt(numbers[1].substring(0,numbers[1].length()-1));
			int twox=Integer.parseInt(numbers[2].substring(1,numbers[2].length()-1));
			int twoy=Integer.parseInt(numbers[3].substring(0,numbers[3].length()-1));
			System.out.println((int)Math.sqrt(Math.pow(twox-onex, 2)+Math.pow(twoy-oney, 2)));
		}
	}
}