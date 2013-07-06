import java.io.*;
public class fileSize{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		System.out.print(file.length());
	}
}