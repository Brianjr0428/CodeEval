import java.io.*;

public class decodeNumbers{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			while ((line = in.readLine()) != null){	
				System.out.println(numOfWays(line,0));
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static int numOfWays(String str, int index){
		if(index>str.length())
			return 0;
		if(index==str.length())
			return 1;
		if(index<str.length()-1&&Integer.parseInt(str.substring(index,index+2))<27)
			return numOfWays(str, index+1)+numOfWays(str, index+2);
		else
			return numOfWays(str, index+1);
	}
}
