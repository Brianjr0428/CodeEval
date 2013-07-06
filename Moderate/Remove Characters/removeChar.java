import java.io.*;
import java.util.HashSet;

public class removeChar{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String[] content;
		HashSet<Character> hash=new HashSet<Character>();
		while ((line = in.readLine()) != null){	
			hash.clear();
			content=line.split(", ");
			for(int i=0;i<content[1].length();i++)
				hash.add(content[1].charAt(i));
			for(int i=0;i<content[0].length();i++){
				if(!hash.contains(content[0].charAt(i)))
					System.out.print(content[0].charAt(i));
			}
			System.out.println();
		}
	}
}
