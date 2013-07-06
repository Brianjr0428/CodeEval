import java.io.*;

public class happyNumbers{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			if(isHappy(Integer.parseInt(line)))
				System.out.println("1");
			else
				System.out.println("0");			
		}
	}
	public static boolean isHappy(int x){
		int digit;
		int sum;
		for(int i=0;i<1000;i++){
			sum=0;
			while(x>0){
				digit=x%10;
				x/=10;
				sum+=Math.pow(digit,2);
			}
			if(sum==1)
				return true;
			x=sum;
		}
		return false;
	}
}