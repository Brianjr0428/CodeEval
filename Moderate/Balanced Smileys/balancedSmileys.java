import java.io.*;

public class balancedSmileys{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){
			if(isBalanced(line,0))
				System.out.println("YES");
			else
				System.out.println("NO");
			
		}
	}
	public static boolean isBalanced(String str, int count){
		if(count==-1)
			return false;
		if(str.length()==0)
			return count==0;
		if(str.charAt(0)=='(')
			return isBalanced(str.substring(1), count+1);
		else if(str.charAt(0)==')')
			return isBalanced(str.substring(1), count-1);
		else if(str.charAt(0)==':'){
			if(str.charAt(1)=='('||str.charAt(1)==')')
				return isBalanced(str.substring(1), count)||isBalanced(str.substring(2), count);
		}
		return isBalanced(str.substring(1), count);
	}
}