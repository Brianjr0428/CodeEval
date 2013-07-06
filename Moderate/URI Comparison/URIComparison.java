import java.io.*;

public class URIComparison{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			String[] urls=line.split(";");
			String url1=urls[0].toLowerCase();
			String url2=urls[1].toLowerCase();
			url1=url1.substring(7);
			url2=url2.substring(7);
			if(compare(url1,url2))
				System.out.println("True");
			else
				System.out.println("False");
			
		}
	}
	public static boolean compare(String url1, String url2){
		String[] group1=url1.split("/");
		String[] group2=url2.split("/");
		if(group1.length!=group2.length)
			return false;
		for(int i=0;i<group1.length;i++){
			if(!transform(group1[i]).equals(transform(group2[i])))
				return false;
		}	
		return true;
	}
	public static String transform(String str){
		if(str.substring(str.length()-3, str.length()).equals(":80"))
			str=str.substring(0,str.length()-3);
		if(str.substring(str.length()-1, str.length()).equals(":"))
			str=str.substring(0,str.length()-1);
		
		if(str.charAt(0)=='%'){			
			str=(char)Integer.parseInt(str.substring(1,3), 16)+str.substring(3);
		}
		return str;
	}
}