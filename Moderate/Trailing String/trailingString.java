import java.io.*;

public class trailingString{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] content;
			while ((line = in.readLine()) != null){	
				if(!line.equals("")){
					content=line.split(",");
					if(compare(content[0],content[1]))
						System.out.println("1");
					else
						System.out.println("0");
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static boolean compare(String str1, String str2){
		if(str1.length()<str2.length())
			return false;
		for(int i=0;i<str2.length();i++){
			if(str1.charAt(str1.length()-str2.length()+i)!=str2.charAt(i))
				return false;
		}
		return true;
	}
}
