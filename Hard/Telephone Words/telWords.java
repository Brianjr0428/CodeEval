import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class telWords{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String[] table={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		int length;
		String result="";
		Queue<String> wordResult=new LinkedList<String>();
		while ((line = in.readLine()) != null){	
			length=line.length();
			printWord(wordResult,line,0,table,result);
			while(!wordResult.isEmpty()){
				if(wordResult.size()>1)
					System.out.print(wordResult.poll()+",");
				else
					System.out.println(wordResult.poll());
			}
		}
	}
	public static void printWord(Queue<String> wordResult,String word, int index,String[] table,String result){
		if(index==word.length())
			wordResult.add(result);
		else{
			int tmpIndex=word.charAt(index)-'0';
			String ref=table[tmpIndex];
			index++;
			for(int i=0;i<ref.length();i++){
				printWord(wordResult,word, index,table,result+ref.charAt(i));
			}
		}
	}
}
