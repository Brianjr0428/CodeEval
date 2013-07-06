import java.io.*;
import java.util.ArrayList;

public class pascalsTriangle{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			int num;
			while ((line = in.readLine()) != null){	
				num=Integer.parseInt(line);
				ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();
				pascal.add(new ArrayList<Integer>());
				pascal.get(0).add(1);
				for(int i=1;i<num;i++){
					pascal.add(new ArrayList<Integer>());
					pascal.get(i).add(1);
					for(int j=1;j<pascal.get(i-1).size();j++)
						pascal.get(i).add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
					pascal.get(i).add(1);
				}
				
				for(ArrayList<Integer> al:pascal){
					for(int i:al)
						System.out.print(i+" ");
				}
				System.out.println();
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
