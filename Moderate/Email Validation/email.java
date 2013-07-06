import java.io.*;
import java.util.regex.*;

public class email {
	public static void main (String[] args){
		try{
			//read the text file
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null){
				String[] lineArray=line.split(" ");
				if(lineArray.length>0){
					Pattern p = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
					Matcher m = p.matcher(line);
					boolean matchCheck = m.matches();
					System.out.println(matchCheck);
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}