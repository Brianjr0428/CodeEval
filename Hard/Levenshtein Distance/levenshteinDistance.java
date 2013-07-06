import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class levenshteinDistance{

	public static class Node{
		boolean isVisited;
		String name;
		public Node(String name){
			this.name=name;
		}
		public void setVisited(){
			this.isVisited=true;
		}
		public boolean checkVisited(){
			return this.isVisited;
		}
	}
	public static class MyCallable implements Callable<ArrayList<Node>>{
		Node currNode;
		HashMap<Integer, ArrayList<Node>> wordSets;
		MyCallable(HashMap<Integer, ArrayList<Node>> wordSets, Node currNode){
			this.wordSets=wordSets;
			this.currNode=currNode;
		}
		public ArrayList<Node>  call() throws Exception{
			return friendList(wordSets, currNode);
		}
	}
	public static ArrayList<Node> friendList(HashMap<Integer, ArrayList<Node>> wordSets, Node currNode){
		ArrayList<Node> result= new ArrayList<Node>();
		for(ArrayList<Node> al:closeWords(currNode, wordSets)){
			for(Node n:al){
				if(!n.checkVisited()){
					if(hammingDistance(currNode,n)==1){
						n.setVisited();
						result.add(n);
					}
				}
			}
		}
		return result;
	}
	public static ArrayList<ArrayList<Node>> closeWords(Node n, HashMap<Integer, ArrayList<Node>> wordSets){
		ArrayList<ArrayList<Node>> result=new ArrayList<ArrayList<Node>>();
		result.add(wordSets.get(n.name.length()));
		if(wordSets.containsKey(n.name.length()-1))
			result.add(wordSets.get(n.name.length()-1));
		if(wordSets.containsKey(n.name.length()+1))
			result.add(wordSets.get(n.name.length()+1));
		return result;
	}
	public static void main (String[] args) throws InterruptedException{
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			HashSet<Node> friends=new HashSet<Node>();
			HashSet<Node> queue=new HashSet<Node>();
			ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
			List<Future<ArrayList<Node>>> list = new ArrayList<Future<ArrayList<Node>>>();
			HashMap<Integer, ArrayList<Node>> wordSets=new HashMap<Integer, ArrayList<Node>>();
			ArrayList<ArrayList<Node>> totalArray=new ArrayList<ArrayList<Node>>();
			LinkedList<Callable<ArrayList<Node>>> tasks=new LinkedList<Callable<ArrayList<Node>>>();;
			int length;
			while ((line = in.readLine()) != null){
				length=line.length();
				if(!wordSets.containsKey(length))
					wordSets.put(length, new ArrayList<Node>());
				wordSets.get(length).add(new Node(line));
			}
			queue.add(new Node("hello"));
			while(!queue.isEmpty()){
				tasks.clear();
				for(Node currNode:queue){
					//totalArray.add(friendList(wordSets,currNode));
					tasks.add(new MyCallable(wordSets, currNode));
				}
				
				list=executor.invokeAll(tasks);
				for (Future<ArrayList<Node>> future : list) {
				      try {
				    	  totalArray.add(future.get());
				      } catch (InterruptedException e) {
				        e.printStackTrace();
				      } catch (ExecutionException e) {
				        e.printStackTrace();
				      }
				}
				queue.clear();
				for(ArrayList<Node> al:totalArray){
					for(Node n:al){
						if(!queue.contains(n)){
							friends.add(n);
							queue.add(n);
						}
					}
				}
				totalArray.clear();
			}
			executor.shutdown();
			System.out.println(friends.size());
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	private static int hammingDistance(Node curr,Node other) {
		int THRESHOLD=1;
		int distance = 0;
		String a = curr.name;
		String b = other.name;
		if(a.length() < b.length()){
		a = b;
		b = curr.name;
		}
		int diff = a.length() - b.length();
		int prefix = 0;
		for(int i = 0 ; i < a.length() ; i ++){
		if(i + prefix < b.length() && a.charAt(i) != b.charAt(i + prefix)){
		if(diff > 0 && prefix == 0){
		prefix = -1;
		} else {
		distance +=1;
		if(distance > THRESHOLD) {
		break;
		}
		}
		}
		}
		return distance + diff;
	}
	
	
	public static int distance(Node n1, Node n2){
		int len1=n1.name.length();
		int len2=n2.name.length();
		int[][] matrix=new int[len1+1][len2+1];
		for(int i =1;i<=len1;i++)
			matrix[i][0]=i;
		for(int i =1;i<=len2;i++)
			matrix[0][i]=i;
		
		for(int i =1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				if(n1.name.charAt(i-1)==n2.name.charAt(j-1))
					matrix[i][j]=matrix[i-1][j-1];
				else
					matrix[i][j]=Math.min(Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1), matrix[i-1][j-1]+1);
			}
		}
		return matrix[len1][len2];
	}
	
}
