import java.io.*;

public class stringRotation{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] strings;
			while ((line = in.readLine()) != null){	
				
				strings=line.split(",");
				if(isRotate(strings[0], strings[1]))
					System.out.println("True");
				else
					System.out.println("False");
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static boolean isRotate(String str1, String str2){
		if(str1.length()!=str2.length())
			return false;
		String newStr=str1;
		for(int i=0;i<=str1.length();i++){
			newStr=newStr.substring(1)+newStr.substring(0,1);
			if(newStr.equals(str2))
				return true;
		}
		return false;
	}
}
