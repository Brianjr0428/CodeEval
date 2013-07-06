import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class commuting{
    public static class Node{
		int num;
		double x;
		double y;
		public Node(int num,double x, double y){
			this.num=num;
			this.x=x;
			this.y=y;
		}
	}
	static double minDistance=Double.MAX_VALUE;
	static String optimalPath="";
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		String[] content;
		int length;
		double x;
		double y;
		int num;
		int count=0;
		ArrayList<Node> nodeArray=new ArrayList<Node>();
		while ((line = in.readLine()) != null){
			count++;
			content = line.split(" ");
			length =content.length;
			x=Double.parseDouble(content[length-2].substring(1,content[length-2].length()-1));
			y=Double.parseDouble(content[length-1].substring(0,content[length-2].length()-1));
			num=Integer.parseInt(content[0]);
			nodeArray.add(new Node(num,x,y));
		}
		double[][] matrix=new double[count+1][count+1];
		for(int i =0;i<count+1;i++){
			matrix[0][i]=-1;
			matrix[i][0]=-1;
		}
		for(int i=0;i<count;i++){
			for(int j=0;j<count;j++)
				if(i==j)
					matrix[i+1][j+1]=-1;
				else	
					matrix[i+1][j+1]=distance(nodeArray.get(i),nodeArray.get(j));
		}
		getPath(0, nodeArray,matrix);
		String[] result=optimalPath.split(" ");
		for(String s:result)
			System.out.println(s);
	}
	public static double distance(Node a, Node b){
		double xDist=a.x-b.x;
		double yDist=a.y-b.y;
		return Math.sqrt(Math.pow(xDist, 2)+Math.pow(yDist,2));
	}
	public static void getPath(int index, ArrayList<Node> nodeArray,double[][] matrix){
		if(index==nodeArray.size()-1){
			double dist=0;
			for(int i=0;i<nodeArray.size()-1;i++)
				dist+=matrix[nodeArray.get(i).num][nodeArray.get(i+1).num];
			if(dist<minDistance){
				optimalPath="";
				for(int i=0;i<nodeArray.size();i++)
					optimalPath+=Integer.toString(nodeArray.get(i).num)+" ";
				minDistance=dist;
			}
		}
		else{
			for(int i=index+1;i<nodeArray.size();i++){
				Collections.swap(nodeArray, index+1, i);
				getPath(index+1, nodeArray,matrix);
				Collections.swap(nodeArray, index+1, i);
			}			
		}
	}	
}