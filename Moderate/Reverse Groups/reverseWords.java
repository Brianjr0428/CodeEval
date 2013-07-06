import java.io.*;
public class reverseWords{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String[] words;
		while ((line = in.readLine()) != null){	
			words=line.split(" ");
			for(int i=words.length-1;i>=0;i--){
				if(i>0)
					System.out.print(words[i]+" ");
				else
					System.out.println(words[i]);
			}
		}
	}
}
