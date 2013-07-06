import java.io.*;

public class countPrimes{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			String[] interval;
			int lowerBound;
			int upperBound;
			int count;
			while ((line = in.readLine()) != null){	
				count=0;
				interval=line.split(",");
				lowerBound=Integer.parseInt(interval[0]);
				upperBound=Integer.parseInt(interval[1]);
				for(int i=lowerBound;i<=upperBound;i++){
					if(isPrime(i))
						count++;
				}
				System.out.println(count);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static boolean isPrime(int x){
		if(x==0||x==1)
			return false;
		if(x==2)
			return true;
		if(x%2==0)
			return false;
		for(int i=3;i<x/2;i+=2){
			if(x%i==0)
				return false;
		}
		return true;
	}
}
