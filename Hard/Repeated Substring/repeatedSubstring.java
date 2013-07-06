import java.io.*;
import java.util.HashMap;

public class repeatedSubstring{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		int maxLength;
		String maxSubStr;
		int currIndex;
		int strLength;
		HashMap<String, Integer> subHash=new HashMap<String, Integer>();
		while ((line = in.readLine()) != null){
			maxLength=0;
			maxSubStr="";
			subHash.clear();
			String subStr;
			for(int i =0;i<line.length()-1;i++){
				for(int j=i+1;j<=line.length();j++){
					if(!emptyString(line.substring(i,j))){
						subStr=line.substring(i,j);
						subHash.clear();
						currIndex=i;
						strLength=subStr.length();
						while(currIndex+strLength<=line.length()){
							if(line.substring(currIndex, currIndex+strLength).endsWith(subStr)){
								if(!subHash.containsKey(subStr))
									subHash.put(subStr, 1);
								else{
									subHash.put(subStr, subHash.get(subStr)+1);
									if(subStr.length()>maxSubStr.length()){
										maxLength=subHash.get(subStr);
										maxSubStr=subStr;
									}
									else if(subStr.length()==maxSubStr.length()&&subHash.get(subStr)>maxLength){
										maxLength=subHash.get(subStr);
										maxSubStr=subStr;
									}
								}
								currIndex+=strLength;
							}
							else
								currIndex++;
						}
					}
				}
			}
			if(maxSubStr.equals(""))
				System.out.println("NONE");
			else
				System.out.println(maxSubStr);
		}
	}
	public static boolean emptyString(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=' ')
				return false;
		}			
		return true;
	}
}