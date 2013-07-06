import java.io.*;

public class stackImplementation{
	public static class stack{
		private Node top;
		public void push(int value){
			Node n=new Node(value);
			n.next=top;
			top=n;
		}
		public int pop(){
			if(top==null)
				return -1;
			else{
				int result=top.value;
				top=top.next;
				return result;
			}
		}
		public boolean isEmpty(){
			return top==null;
		}
	}
	public static class Node{
		private int value;
		private Node next;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String[] content;
		boolean alternate;
		while ((line = in.readLine()) != null){	
			if(!line.equals("")){
				alternate=true;
				content=line.split(" ");
				stack stack=new stack();
				for(String s:content)
					stack.push(Integer.parseInt(s));
				while(!stack.isEmpty()){
					if(alternate)
						System.out.print(stack.pop()+" ");
					else 
						stack.pop();
					alternate=switchBoolean(alternate);
				}
				System.out.println();
			}
		}
	}
	public static boolean switchBoolean(boolean b){
		if(b)
			return false;
		else
			return true;
	}
}