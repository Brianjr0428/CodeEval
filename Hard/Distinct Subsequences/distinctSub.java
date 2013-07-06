import java.io.*;

public class distinctSub{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String[] words;
		while ((line = in.readLine()) != null){	
			words=line.split(",");
			System.out.println(countOccur(words[0], words[1], 0, 0));
		}
	}
	public static int countOccur(String seq, String subseq, int i, int j){
		if(j==subseq.length()){
			if(seq.charAt(i-1)==subseq.charAt(j-1))
				return 1;
			else
				return 0;
		}
		if(i==seq.length())
			return 0;
		if(seq.charAt(i)==subseq.charAt(j))
			return countOccur(seq, subseq, i+1, j+1)+countOccur(seq, subseq, i+1, j);
		else 
			return countOccur(seq, subseq, i+1, j);
	}
}
