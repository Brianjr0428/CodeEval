import java.io.*;

public class numOfOnes{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			int num;
			int count;
			while ((line = in.readLine()) != null){	
				count=0;
				num=Integer.parseInt(line);
				while(num>0){
					if(num%2!=0){
						num-=1;
						count++;
					}
					num/=2;
				}
				System.out.println(count);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
