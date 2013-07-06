import java.io.*;
import java.util.ArrayList;
public class minPathSum{
	static int minSum=Integer.MAX_VALUE;
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] content;
		int rows;
		int rowIndex=0;
		ArrayList<int[][]> martixArray=new ArrayList<int[][]>();
		while ((line = in.readLine()) != null){	
			content = line.split(",");
			if(content.length==1){
				rowIndex=0;
				rows=Integer.parseInt(content[0]);
				martixArray.add(new int[rows][rows]);
			}
			else{
				for(int i=0;i<content.length;i++){
					martixArray.get(martixArray.size()-1)[rowIndex][i]=Integer.parseInt(content[i]);
				}
				rowIndex++;
			}
		}
		for(int[][] iMatrix:martixArray){
			System.out.println(minPath(iMatrix,0,0));
		}
	}
	public static int minPath(int[][] matrix, int row, int col){
		if(row==matrix.length-1&&col==matrix[0].length-1)
			return matrix[row][col];
		if(col==matrix.length-1)
			return matrix[row][col]+minPath(matrix, row+1, col);
		if(row==matrix.length-1)
			return matrix[row][col]+minPath(matrix, row, col+1);
		else
			return matrix[row][col]+Math.min(minPath(matrix, row+1, col), minPath(matrix, row, col+1));
	}
	public static void minPath2(int[][] matrix, int row, int col, int sum){
		if(row==matrix.length-1&&col==matrix[0].length-1){
			if(matrix[row][col]+sum<minSum)
				minSum=matrix[row][col]+sum;
		}
		else if(col==matrix.length-1)
			minPath2(matrix, row+1, col,matrix[row][col]+sum);
		else if(row==matrix.length-1)
			minPath2(matrix, row, col+1,matrix[row][col]+sum);
		else{
			minPath2(matrix, row+1, col,matrix[row][col]+sum);
			minPath2(matrix, row, col+1,matrix[row][col]+sum);
		}
	}
}
