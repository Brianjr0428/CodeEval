import java.io.*;
import java.util.Hashtable;;
public class selfDescribing{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		Hashtable<Integer,Integer> hash= new Hashtable<Integer,Integer> ();
		while ((line = in.readLine()) != null){	
			hash.clear();
			for(int i=0;i<line.length();i++){
				int key=Character.getNumericValue(line.charAt(i));
				if(!hash.containsKey(key))
					hash.put(key, 1);
				else
					hash.put(key, hash.get(key)+1);
			}
			if(isSelf(line,hash))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
	public static boolean isSelf(String str,Hashtable<Integer,Integer> hash){
		int value;
		int number;
		for(int i=0;i<str.length();i++){
			value=Character.getNumericValue(str.charAt(i));
			if(!hash.containsKey(i))
				number=0;
			else
				number=hash.get(i);
			if(number!=value)
				return false;
		}
		return true;
	}
}