import java.io.*;
public class PrimeNums {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null){				
			int num=Integer.parseInt(line);
			boolean start=false;
			for(int i=2;i<=num;i++){
				if(prime(i)){
					if(!start){
						System.out.print(i);
						start=true;
					}
					else
						System.out.print(","+i);
					}
			}
			System.out.println();
			}
	}
	public static boolean prime(int num){
		if(num<2)
			return false;
		if(num==2)
			return true;
		if(num%2==0)
			return false;
		for(int i=3;i<=num/2;i+=2){
			if(num%i==0)
				return false;
		}
		return true;
	}
}
