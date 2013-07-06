import java.io.*;

public class flaviusJosephus{
	public static class Node{
		private int value;
		private Node next;
		public Node(int value){
			this.value=value;
		}
		public void add(int value){
			Node current=this;
			while(current.next!=null)
				current=current.next;
			current.next=new Node(value);
		}
	}
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] content;
			int numbers;
			int interval;
			int step;
			while ((line = in.readLine()) != null){	
				content=line.split(",");
				numbers=Integer.parseInt(content[0]);
				interval=Integer.parseInt(content[1]);
				Node head=new Node(0);
				for(int i=1;i<numbers;i++)
					head.add(i);
				Node tail=head;
				while(tail.next!=null)
					tail=tail.next;
				tail.next=head;
				while(tail.next!=tail){
					step=interval-1;
					while(step>0){
						tail=tail.next;
						step--;
					}
					System.out.print(tail.next.value+" ");
					tail.next=tail.next.next;
				}
				System.out.println(tail.value);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
