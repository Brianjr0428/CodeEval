import java.io.*;
import java.util.HashMap;
public class numberPairs{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String[] content;
		String[] numberArray;
		int[] numbers;
		int x;
		int temp;
		String result;
		HashMap<Integer, Boolean> hash=new HashMap<Integer, Boolean>();
		while ((line = in.readLine()) != null){	
			result="";
			content=line.split(";");
			x=Integer.parseInt(content[1]);
			numberArray=content[0].split(",");
			numbers=new int[numberArray.length];
			for(int i=0;i<numberArray.length;i++){
				numbers[i]=Integer.parseInt(numberArray[i]);
				hash.put(numbers[i], false);
			}
			for(int i:numbers){
				if(!hash.get(i)){
					temp=x-i;
					if(temp!=i&&hash.containsKey(temp)){
						hash.put(i, true);
						hash.put(temp, true);
						if(result=="")
							result+=i+","+temp;
						else
							result+=";"+i+","+temp;							
					}
				}
			}
			if(result=="")
				System.out.println("NULL");
			else
				System.out.println(result);
		}
	}
}
