import java.io.*;

public class sSearching {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){
			String[] sArray=line.split(",");
			if(subMatch(sArray[0],sArray[1]))
				System.out.println("true");
			else
				System.out.println("false");
		}
	}
	public static boolean subMatch(String str1, String str2){
		int index1=0;
		int index2=0;
		while(index1<str1.length()){
			if(str1.charAt(index1)==str2.charAt(index2)){
				index2++;
				if(index2==str2.length())
					return true;
			}
			else if(str2.charAt(index2)=='*'){
				index2++;
				if(index2==str2.length())
					return true;
				while(str1.charAt(index1)!=str2.charAt(index2))
					index1++;
				index2++;
				if(index2==str2.length())
					return true;
			}
			else if(str2.charAt(index2)=='\\'){				
				index2++;
				if(str1.charAt(index1)!='*')
					return false;
				index1++;
				index2++;
				if(index2==str2.length())
					return true;
			}
			else
				index2=0;
			index1++;
		}
		return false;
	}
}
