import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class permutation {
	public static void main (String[] args){
		try{
			//read the text file
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			ArrayList<String> wordArray = new ArrayList<String>(); 
			while ((line = in.readLine()) != null){
				wordArray.clear();
				char[] newLine = line.toCharArray();
				permutation(0,newLine,wordArray);
				Collections.sort(wordArray);
				for(int i=0;i<wordArray.size();i++){
					if(i<wordArray.size()-1)
						System.out.print(wordArray.get(i)+",");
					else
						System.out.print(wordArray.get(i));
					}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	static public void permutation(int index, char[] str, ArrayList<String> wordArray){
		if(index==str.length-1){
			addToVector(str, wordArray);
		}
		for(int i=index;i<str.length;i++){
			swap(index,i,str);
			permutation(index+1, str, wordArray);
			swap(index,i,str);
		}
		
	}
	static public void swap(int a,int b, char[] str){
		char tmp;
		tmp= str[a];
		str[a] = str[b];
		str[b] = tmp;
	}
	static public void addToVector(char[] str, ArrayList<String> wordArray){
		wordArray.add(new String(str));
	}
}
