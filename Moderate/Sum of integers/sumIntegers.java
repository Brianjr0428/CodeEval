import java.io.*;

public class sumIntegers{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			while ((line = in.readLine()) != null){	
				int maxSum=0;
				int currSum=0;
				String[] content=line.split("[, ]+");
				for(int i=0;i<content.length;i++){
					currSum+=Integer.parseInt(content[i]);
					if (currSum<0)
						currSum=0;
					if(currSum>maxSum)
						maxSum=currSum;
				}
				System.out.println(maxSum);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}