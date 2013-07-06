import java.io.*;

public class minesweeper{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String content[];
			String[] rowCol;
			int row;
			int col;
			while ((line = in.readLine()) != null){	
				content=line.split(";");
				rowCol=content[0].split(",");
				row=Integer.parseInt(rowCol[0]);
				col=Integer.parseInt(rowCol[1]);
				char[][] matrix = new char[row][col];
				int index=0;
				for(int i=0;i<row;i++){
					for(int j=0;j<col;j++){
						matrix[i][j]=content[1].charAt(index);
						index++;
					}
				}
				for(int i=0;i<row;i++){
					for(int j=0;j<col;j++){
						if(matrix[i][j]=='*')
							System.out.print("*");
						else
							System.out.print(calculate(matrix, i-1,j-1)+calculate(matrix,i-1,j)+calculate(matrix, i-1,j+1)+calculate(matrix, i,j-1)+calculate(matrix, i,j+1)+calculate(matrix, i+1,j-1)+calculate(matrix, i+1,j)+calculate(matrix, i+1,j+1));
					}
				}
				System.out.println();
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static int calculate(char[][] matrix, int row, int col){
		if(row==-1||row==matrix.length||col==matrix[0].length||col==-1||matrix[row][col]!='*')
			return 0;
		return 1;
	}
}
