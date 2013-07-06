import java.io.*;
import java.util.HashSet;;

public class doubleSquares{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		boolean first=false;
		int number;
		int upperBound;
		int secondNum;
		int tempNum;
		int count=0;
		int arrayIndex=0;
		int[] result=null;
		HashSet<Integer> hash=new HashSet<Integer>();
		while ((line = in.readLine()) != null){
			if(!line.equals("")){
				if(!first){
					result=new int[Integer.parseInt(line)];
					arrayIndex=0;
					first=true;
				}
				else{
					hash.clear();
					count=0;
					number=Integer.parseInt(line);
					upperBound=(int)Math.sqrt(number)+1;
					for(int i=0;i<upperBound;i++){
						if(!hash.contains(i)){
							tempNum=number-(int)Math.pow(i, 2);
							if(Math.sqrt(tempNum)==(int)Math.sqrt(tempNum)){
								secondNum=(int)Math.sqrt(tempNum);
								count++;
								hash.add(i);
								hash.add(secondNum);
							}
						}
					}
					result[arrayIndex]=count;
					arrayIndex++;
				}
			}
		}
		for(int i:result)
			System.out.println(i);
	}
}
