import java.io.*;
import java.util.ArrayList;

public class uniqueElements {
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			while ((line = in.readLine()) != null){	
				String[] numbers=line.split(",");
				ArrayList<Integer> numArray=new ArrayList<Integer>();
				numArray.add(Integer.parseInt(numbers[0]));
				for(int i=1;i<numbers.length;i++){
					if(Integer.parseInt(numbers[i])!=Integer.parseInt(numbers[i-1]))
						numArray.add(Integer.parseInt(numbers[i]));
				}
				for(int i=0;i<numArray.size();i++){
					if(i!=numArray.size()-1)
						System.out.print(numArray.get(i)+",");
					else
						System.out.println(numArray.get(i));
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
