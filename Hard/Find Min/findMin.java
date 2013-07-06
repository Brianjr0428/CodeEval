import java.io.*;
import java.util.ArrayList;

public class findMin{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] content;
			int n,k,a,b,c,r,m;
			int result;
			ArrayList<Integer> numArray;
			while ((line = in.readLine()) != null){	
				numArray=new ArrayList<Integer>();
				content = line.split(",");
				n=Integer.parseInt(content[0]);
				k=Integer.parseInt(content[1]);
				a=Integer.parseInt(content[2]);
				b=Integer.parseInt(content[3]);
				c=Integer.parseInt(content[4]);
				r=Integer.parseInt(content[5]);
				numArray.add(a);
				for(int i=1;i<k;i++)
					numArray.add((b * numArray.get(numArray.size()-1) + c) % r);
				for(int i=k;i<n;i++){
					result=0;
					while(true){
						if(numArray.subList(numArray.size()-k, numArray.size()).contains(result))
							result++;
						else
							break;
					}
					numArray.add(result);
				}
				System.out.println(numArray.get(numArray.size()-1));
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
