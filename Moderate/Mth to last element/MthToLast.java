import java.io.*;
import java.util.Stack;

public class MthToLast {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null){
			String stIndex=new String();
			int num=0;
			//make a stack to store characters
			Stack<String> stack=new Stack<String>();
			String[] lineArray=line.split(" ");
			if(lineArray.length>0){
				//push non-space character into the stack
				for (String st:lineArray)
					stack.add(st);
				int index = Integer.parseInt(stack.pop());
				while(!stack.empty()){
					//check each charater from the end of the list until the Mth element 
					num++;
					stIndex=stack.pop();
					if(num==index)
						System.out.println(stIndex);
				}		
			}
		}
	}
}