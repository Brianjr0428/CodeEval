import java.io.*;

public class minCoins{
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
				while(num>=5){
					num-=5;
					count++;
				}
				while(num>=3){
					num-=3;
					count++;
				}
				while(num>=1){
					num-=1;
					count++;
				}
				System.out.println(count);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
