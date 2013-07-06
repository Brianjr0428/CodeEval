import java.io.*;

public class lowestCommonAncestor{
	public static class treeNode{
		private int value;
		private treeNode left;
		private treeNode right;
		public treeNode(int value){
			this.value=value;
		}
		public void add (int value){
			if (value<=this.value){
				if(this.left==null)
					this.left=new treeNode(value);
				else
					this.left.add(value);
			}
			if (value>this.value){
				if(this.right==null)
					this.right=new treeNode(value);
				else
					this.right.add(value);
			}
		}
	}
	public static boolean existNode(int value, treeNode root){
		if(root==null)
			return false;
		if(value==root.value)
			return true;
		else if(value<root.value)
			return existNode(value, root.left);
		else 
			return existNode(value, root.right);	
	}
	public static treeNode findLCA(treeNode root,int value1, int value2){
		if(existNode(value1,root)&&existNode(value2,root))
			return LCA(root,value1, value2);
		else 
			return null;
	}
	public static treeNode LCA(treeNode root,int value1, int value2){
		if(root.value==value1||root.value==value2)
			return root;
		if(root.value>value1&&root.value<value2)
			return root;
		if(root.value>value1||root.value>value2)
			return LCA(root.left,value1, value2);
		else 
			return LCA(root.right,value1, value2);
	}
	public static void main (String[] args){
		try{
			treeNode root=new treeNode(30);
			root.add(8);
			root.add(52);
			root.add(3);
			root.add(20);
			root.add(10);
			root.add(29);
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] nodes;
			int value1;
			int value2;
			while ((line = in.readLine()) != null){	
				nodes=line.split(" ");
				value1=Integer.parseInt(nodes[0]);
				value2=Integer.parseInt(nodes[1]);
				System.out.println(LCA(root,value1, value2).value);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
