import java.io.*;
import java.util.ArrayList;

public class DaVyncy {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			int[] numArray=new int[2];
			ArrayList<String> wordArray=new ArrayList<String>();
			String[] words=line.split(";");
			for(int i=0;i<words.length;i++)
				wordArray.add(words[i]);
			while(wordArray.size()>1){
				numArray[0]=0;
				numArray[1]=-1;
				findBestMatch(wordArray,numArray);
				combineMatch(wordArray,numArray);
			}
			System.out.println(wordArray.get(0));
		}
	}
	public static int matchNumber(String str1,String str2){
		int num=1;
		String a="";
		String b="";
		if(str1.length()>=str2.length()){
			for(int i =1;i<=str1.length()+str2.length();i++){	
				if(i<=str1.length()&&i<=str2.length()){
					a=str1.substring(str1.length()-i, str1.length());
					b=str2.substring(0, i);
				}
				else if(i<=str1.length()&&i>str2.length()){
					a=str1.substring(str1.length()-i, str1.length()-i+str2.length());
					b=str2;
				}
				else if(i>str1.length()){
					a=str1.substring(0, str1.length()+str2.length()-i);
					b=str2.substring(i-str1.length(), str2.length());
				}
				if(a.equals(b)){
					if(a.length()>num)
					num=a.length();
				}
			}
		}
		else{
			for(int i =1;i<=str2.length()+str1.length();i++){
				if(i<=str2.length()&&i<=str1.length()){
					a=str2.substring(str2.length()-i, str2.length());
					b=str1.substring(0, i);
				}
				else if(i<=str2.length()&&i>str1.length()){
					a=str2.substring(str2.length()-i, str2.length()-i+str1.length());
					b=str1;
				}
				else if(i>str2.length()){
					a=str2.substring(0, str2.length()+str1.length()-i);
					b=str1.substring(i-str2.length(), str1.length());
				}
				
				if(a.equals(b)){
					if(a.length()>num)
					num=a.length();
				}
			}
		}
		return num;
	}
	public static void findBestMatch(ArrayList<String> wordArray, int[] numArray){
		for(int i=1;i<wordArray.size();i++){
			if(Math.max(matchNumber(wordArray.get(0), wordArray.get(i)), matchNumber(wordArray.get(i), wordArray.get(0)))>numArray[1]){
				numArray[1]=Math.max(matchNumber(wordArray.get(0), wordArray.get(i)), matchNumber(wordArray.get(i), wordArray.get(0)));
				numArray[0]=i;
			}
		}
	}
	public static void combineMatch(ArrayList<String> wordArray, int[] numArray){
		if(numArray[1]>0){
			if(wordArray.get(0).substring(wordArray.get(0).length()-numArray[1]).equals(wordArray.get(numArray[0]).subSequence(0, numArray[1])))			
				wordArray.set(0,wordArray.get(0)+wordArray.get(numArray[0]).substring(numArray[1]));
			else if(wordArray.get(numArray[0]).substring(wordArray.get(numArray[0]).length()-numArray[1]).equals(wordArray.get(0).subSequence(0, numArray[1])))
				wordArray.set(0,wordArray.get(numArray[0])+wordArray.get(0).substring(numArray[1]));
		}
		wordArray.remove(numArray[0]);
	}
}
