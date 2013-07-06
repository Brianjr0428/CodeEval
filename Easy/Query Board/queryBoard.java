import java.io.*;

public class queryBoard{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		int[][] table=new int[256][256];
		for(int i=0;i<256;i++){
			for(int j=0;j<256;j++)
				table[i][j]=0;
		}
		while ((line = in.readLine()) != null){
			String[] content=line.split(" ");
			if(content[0].equals("SetCol")){
				int col=Integer.parseInt(content[1]);
				int x=Integer.parseInt(content[2]);
				for(int i=0;i<256;i++){
					table[i][col]=x;
				}
			}
			else if(content[0].equals("SetRow")){
				int row=Integer.parseInt(content[1]);
				int x=Integer.parseInt(content[2]);
				for(int i=0;i<256;i++){
					table[row][i]=x;
				}
			}
			else if(content[0].equals("QueryCol")){
				int col=Integer.parseInt(content[1]);
				int sum=0;
				for(int i=0;i<256;i++){
					sum+=table[i][col];
				}
				System.out.println(sum);
			}
			else if(content[0].equals("QueryRow")){
				int row=Integer.parseInt(content[1]);
				int sum=0;
				for(int i=0;i<256;i++){
					sum+=table[row][i];
				}
				System.out.println(sum);
			}
		}
	}
}