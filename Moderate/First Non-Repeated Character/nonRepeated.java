import java.io.*;

public class nonRepeated{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			for(int i=0;i<line.length();i++){
				if(!isRepeated(i,line)){
					System.out.println(line.charAt(i));
					break;
				}
			}
		}
	}
	public static boolean isRepeated(int index, String str){
		for(int i=0;i<str.length();i++){
			if(i==index)
				continue;
			if(str.charAt(i)==str.charAt(index))
				return true;
		}
		return false;
	}
}
