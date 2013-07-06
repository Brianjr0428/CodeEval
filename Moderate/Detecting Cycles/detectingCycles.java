import java.io.*;
import java.util.ArrayList;

public class detectingCycles{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String content[];
		ArrayList<String> sequence;
		int index=0;
		while ((line = in.readLine()) != null){	
			sequence = new ArrayList<String>();
			content=line.split(" ");
			for(String s:content){
				if(!sequence.contains(s))
					sequence.add(s);
				else{
					index=sequence.indexOf(s);
					break;
				}
			}
			for(int i=index;i<sequence.size();i++){
				if(i==sequence.size()-1)
					System.out.println(sequence.get(i));
				else
					System.out.print(sequence.get(i)+" ");
			}
		}
	}
}
