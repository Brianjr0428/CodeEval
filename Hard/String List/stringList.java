import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class stringList {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		int length;
		ArrayList<Character> words=new ArrayList<Character>();
		HashMap<Character,Boolean> map=new HashMap<Character,Boolean>();
		while ((line = in.readLine()) != null){	
			words.clear();
			map.clear();
			String[] strList=line.split(",");
			length=Integer.parseInt(strList[0]);
			char[] tmp=strList[1].toCharArray();
			
			for(int i=0;i<tmp.length;i++){
				if(!map.containsKey(tmp[i])){
					map.put(tmp[i], true);
					words.add(tmp[i]);
				}
			}
			Collections.sort(words);
			
			char[] charArray=new char[length];
			printList(words, charArray,0, length);
			System.out.println();
		}
	}
	public static void printList(ArrayList<Character> words, char[] charArray,int curr, int length){
		if(curr==length){
			for(int i =0;i<length;i++){
				System.out.print(charArray[i]);
			}
			if(!checkLast(words, charArray))
				System.out.print(",");
		}
		else{
			for(int i=0;i<words.size();i++){
				charArray[curr]=words.get(i);
				printList(words, charArray,curr+1, length);
			}
		}
	}
	public static boolean checkLast(ArrayList<Character> words, char[] charArray){
		for(int i=0;i<charArray.length;i++){
			if(charArray[i]!=words.get(words.size()-1))
				return false;
		}
		return true;
	}
}
