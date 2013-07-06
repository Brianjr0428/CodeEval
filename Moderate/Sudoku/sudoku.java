import java.io.*;

public class sudoku{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		int num;
		while ((line = in.readLine()) != null){	
			String[] content=line.split(";");
			String[] numbers=content[1].split(",");
			num=Integer.parseInt(content[0]);
			int[][] sudoku=new int[num][num];
			int index=0;
			for(int i=0;i<num;i++){
				for(int j=0;j<num;j++){
					sudoku[i][j]=Integer.parseInt(numbers[index]);
					index++;
				}
			}
			if(isValid(sudoku))
				System.out.println("True");
			else
				System.out.println("False");
		}
	}
	public static boolean vValid(int[][] sudoku, int index){
		boolean[] test=new boolean[sudoku.length+1];
		test[0]=true;
		for(int i=0;i<sudoku.length;i++){
			test[sudoku[i][index]]=true;
		}
		for(int i=0;i<test.length;i++){
			if(test[i]==false)
				return false;
		}
		return true;
	}
	public static boolean hValid(int[][] sudoku, int index){
		boolean[] test=new boolean[sudoku[0].length+1];
		test[0]=true;
		for(int i=0;i<sudoku.length;i++){
			test[sudoku[index][i]]=true;
		}
		for(int i=0;i<test.length;i++){
			if(test[i]==false)
				return false;
		}
		return true;
	}
	public static boolean gridValid(int[][] sudoku, int row, int col){
		int grids=(int)Math.sqrt(sudoku.length);
		boolean[] test=new boolean[sudoku[0].length+1];
		test[0]=true;
		for(int i=0;i<grids;i++){
			for(int j=0;j<grids;j++)
				test[sudoku[row+i][col+j]]=true;
		}
		for(int i=0;i<test.length;i++){
			if(test[i]==false)
				return false;
		}
		return true;
	}
	public static boolean isValid(int[][] sudoku){
		int rows=sudoku.length;
		for(int i=0;i<rows;i++){
			if(!hValid(sudoku, i)||!vValid(sudoku, i))
				return false;
		}
		int grid=(int)Math.sqrt(sudoku.length);
		for(int i=0;i<rows;i+=grid){
			for(int j=0;j<rows;j+=grid){
				if(!gridValid(sudoku, i, j))
					return false;
			}
		}
		return true;
	}
}
