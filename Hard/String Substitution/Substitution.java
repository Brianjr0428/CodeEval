import java.io.*;

public class Substitution {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String input;
		int s1Index;
		int s2Index;
		
		while ((line = in.readLine()) != null){	
			s2Index=0;
			String[] strs1=line.split(";");
			input = strs1[0];
			String[] strs2 = strs1[1].split(",");
			while(s2Index!=strs2.length){
				s1Index=0;
				while(s1Index<input.length()){
					if(subCheck(input,strs2[s2Index],s1Index)){
						input = input.substring(0, s1Index)+tranString(strs2[s2Index+1])+input.substring(s1Index+strs2[s2Index].length(), input.length());	
						s1Index+=strs2[s2Index+1].length();
					}	
					else
						s1Index++;
				}
				s2Index+=2;
			}
			decodeString(input);
		}
	}
	public static String tranString(String str){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='0')
				sb.append('a');
			else if(str.charAt(i)=='1')
				sb.append('b');
		}
		return sb.toString();
	}
	public static boolean subCheck(String s1, String s2, int begin){
		for(int i=0;i<s2.length();i++){
			if(begin+i==s1.length())
				return false;
			if(s1.charAt(begin+i)!=s2.charAt(i))
				return false;
		}
		return true;
	}
	public static void decodeString(String str){
		for(int i =0;i< str.length();i++){
			if(str.charAt(i)=='a')
				System.out.print("0");
			else if(str.charAt(i)=='b')
				System.out.print("1");
			else 
				System.out.print(str.charAt(i));
		}
		System.out.println();
	}
}
