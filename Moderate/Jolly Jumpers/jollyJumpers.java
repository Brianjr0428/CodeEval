import java.io.*;
public class jollyJumpers{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] content;
			int[] numbers;
			boolean[] check;
			int number;
			while ((line = in.readLine()) != null){	
				content=line.split(" ");
				number=Integer.parseInt(content[0]);
				numbers=new int[number];
				check=new boolean[number];
				check[0]=true;
				for(int i=1;i<content.length;i++)
					numbers[i-1]=Integer.parseInt(content[i]);
				if(isJolly(numbers, check))
					System.out.println("Jolly");
				else
					System.out.println("Not jolly");
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static boolean isJolly(int[] numbers, boolean[] check){
		int diff;
		for(int i=0;i<numbers.length-1;i++){
			diff=Math.abs(numbers[i]-numbers[i+1]);
			if(diff<check.length)
				check[diff]=true;
		}
		for(int i=0;i<check.length;i++){
			if(check[i]==false)
				return false;
		}
		return true;
	}
}
