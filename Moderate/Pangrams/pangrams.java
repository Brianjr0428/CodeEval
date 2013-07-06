import java.io.*;
import java.util.HashSet;

public class pangrams{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		HashSet<Integer> hash=new HashSet<Integer>();
		int[] numArray=new int[26];
		String result;
		for(int i =0;i<26;i++)
			numArray[i]=i;
		while ((line = in.readLine()) != null){	
			result="";
			hash.clear();
			for(int i=0;i<line.length();i++){
				if(!hash.contains((int)line.charAt(i)))
					hash.add((int)line.charAt(i));
			}
			for(int i=0;i<26;i++){
				if(!hash.contains(i+65)&&!hash.contains(i+97))
					result+=(char)(97+numArray[i]);
			}
			if(result.equals(""))
				System.out.println("NULL");
			else
				System.out.println(result);
		}
	}
}