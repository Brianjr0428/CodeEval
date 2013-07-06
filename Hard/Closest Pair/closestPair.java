import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class closestPair {
	static class Node{
		private Double x;
		private Double y;
		public Node(Double x, Double y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		double x;
		double y;
		double distance=0;
		double minDistance=Float.MAX_VALUE;
		ArrayList<ArrayList<Node>> nodeArray=new ArrayList<ArrayList<Node>>();
		while ((line = in.readLine()) != null){	
			if(line.split(" ").length==1){
				if(line.equals("0"))
					break;
				if(Integer.parseInt(line)<0||Integer.parseInt(line)>10000)
					break;
				else{
					nodeArray.add(new ArrayList<Node>());						
				}
			}
			else {
				String[] coor=line.split(" ");
				x=Double.parseDouble(coor[0]);
				y=Double.parseDouble(coor[1]);
				if(x>=0&&x<=4000&&y>=0&&y<=4000)
					nodeArray.get(nodeArray.size()-1).add(new Node(x,y));	
			}
		}
		for(ArrayList<Node> na:nodeArray){
			for(int i=0;i<na.size()-1;i++){
				for(int j=i+1;j<na.size();j++){
					distance=distance(na.get(i),na.get(j));
					if(distance<minDistance)
						minDistance=distance;
				}
			}
			if(minDistance>10000)
				System.out.println("INFINITY");
			else
				System.out.println(new DecimalFormat("##.####").format(minDistance));
		}
	}
	public static double distance(Node n1, Node n2){
		return Math.sqrt(Math.pow(Math.abs(n1.x-n2.x),2)+Math.pow(Math.abs(n1.y-n2.y),2));
	}
}
