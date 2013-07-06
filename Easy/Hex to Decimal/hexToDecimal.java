import java.io.*;

public class hexToDecimal{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){
			int sum=0;
			for(int i=0;i<line.length();i++)
				sum=sum*16+hTod(line.charAt(i));
			System.out.println(sum);
		}
	}
	public static int hTod(char c){
		switch(c){
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case 'a':
				return 10;
			case 'A':
				return 10;
			case 'b':
				return 11;
			case 'B':
				return 11;
			case 'c':
				return 12;
			case 'C':
				return 12;
			case 'd':
				return 13;
			case 'D':
				return 13;
			case 'e':
				return 14;
			case 'E':
				return 14;
			case 'f':
				return 15;
			case 'F':
				return 15;
			default:
				return 0;
		}
	}
}