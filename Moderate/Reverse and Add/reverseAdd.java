import java.io.*;

public class reverseAdd{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			int number;
			int count;
			while ((line = in.readLine()) != null){	
				count=0;
				number=Integer.parseInt(line);
				for(int i=0;i<1000;i++){
					count++;
					number+=reverseInt(number);
					if(isPalindrome(Integer.toString(number)))
						break;
				}
				System.out.println(count+ " "+number);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static int reverseInt(int x){
		int result=0;
		while(x>0){
			result*=10;
			result+=x%10;
			x/=10;
		}
		return result;
	}
	public static boolean isPalindrome(String number){
		int head=0;
		int tail=number.length()-1;
		while(head<=tail){
			if(number.charAt(head)!=number.charAt(tail))
				return false;
			head++;
			tail--;
		}
		return true;
	}
}
