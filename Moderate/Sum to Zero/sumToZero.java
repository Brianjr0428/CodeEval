import java.io.*;

public class sumToZero{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] numbers;
			while ((line = in.readLine()) != null){	
				numbers=line.split(",");
				System.out.println(sumZero(numbers, 0, 0, 0));
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static int sumZero(String[] strArray, int index, int count, int sum){
		if(count==4){
			if(sum==0)
				return 1;
			else
				return 0;
		}
		if(index==strArray.length)
			return 0;
		int currNum=Integer.parseInt(strArray[index]);
		return sumZero(strArray, index+1, count, sum)+sumZero(strArray, index+1, count+1, sum+currNum);
	}
}
