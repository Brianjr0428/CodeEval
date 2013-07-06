import java.io.*;
import java.util.Stack;

public class prefix {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		Stack<Character> stack1=new Stack<Character>();
		Stack<Integer> stack2=new Stack<Integer>();
		int p=0;
		while ((line = in.readLine()) != null){
			for (int i=0;i<line.length();i++){
				if(line.charAt(i)!=' ')
					stack1.push(line.charAt(i));
			}
			while(!stack1.empty()){
				if(stack1.peek()=='+'){
					stack1.pop();
					stack2.push(stack2.pop()+stack2.pop());
				}
				else if(stack1.peek()=='*'){
					stack1.pop();
					stack2.push(stack2.pop()*stack2.pop());
				}
				else if(stack1.peek()=='/'){
					stack1.pop();
					stack2.push(stack2.pop()/stack2.pop());
				}
				else{
					stack2.push(Character.getNumericValue(stack1.pop()));
				}
			}
			System.out.println(stack2.peek());
		}
	}
}
