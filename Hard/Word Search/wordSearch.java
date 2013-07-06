import java.io.*;

public class wordSearch{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
			while ((line = in.readLine()) != null){	
				if(searchWord(line, board))
					System.out.println("True");
				else
					System.out.println("False");
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static boolean searchWord(String word, char[][] board){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				boolean[][] visited=new boolean[board.length][board[0].length];
				if(findWord(visited, word, 0, i,j, board))
					return true;
			}
		}
		return false;
	}
	public static boolean findWord(boolean[][] visited, String word, int index, int yCoor, int xCoor, char[][] board){
		if(yCoor==board.length||yCoor==-1||xCoor==board[0].length||xCoor==-1||visited[yCoor][xCoor]||visited[yCoor][xCoor]||word.charAt(index)!=board[yCoor][xCoor])
			return false;
		visited[yCoor][xCoor]=true;
		if(index==word.length()-1)
			return true;
		else return(findWord(visited, word, index+1, yCoor-1, xCoor, board)
				  ||findWord(visited, word, index+1, yCoor+1, xCoor, board)
				  ||findWord(visited, word, index+1, yCoor, xCoor-1, board)
				  ||findWord(visited, word, index+1, yCoor, xCoor+1, board));
	}
}
