import java.io.*;
import java.util.Stack;
public class validParentheses{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			Stack<Character> paranthesesStack= new Stack<Character>();
			while ((line = in.readLine()) != null){	
				if(isValid(line, paranthesesStack))
					System.out.println("True");
				else
					System.out.println("False");
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static boolean isValid(String str, Stack<Character> paranthesesStack){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{')
				paranthesesStack.push(str.charAt(i));
			if(str.charAt(i)==')'){
				if(paranthesesStack.peek()!='(')
					return false;
				else
					paranthesesStack.pop();
			}
			if(str.charAt(i)==']'){
				if(paranthesesStack.peek()!='[')
					return false;
				else
					paranthesesStack.pop();
			}
			if(str.charAt(i)=='}'){
				if(paranthesesStack.peek()!='{')
					return false;
				else
					paranthesesStack.pop();
			}
		}
		return true;
	}
}
