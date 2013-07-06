import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class SpiralPrinting{
    public static void main (String[] args) throws IOException{
    int rows;
    int cols;
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split(";");
        if (lineArray.length > 0) {
        	rows = Integer.parseInt(lineArray[0]);
        	cols = Integer.parseInt(lineArray[1]);
        	String[][] elements= new String[rows][cols];
        	String[] content=lineArray[2].split(" ");
        	int count=0;
        	int row=0;
        	int col=0;
        	while(count<content.length){
        		elements[row][col]=content[count];
        		if(col<cols-1)
        			col++;
        		else{
        			col=0;
        			row++;
        		}
        		count++;
        	}
        	LtoR(elements,0,cols-1,0,rows-1);
        	System.out.println();
        }
    }
   }
    public static void LtoR(String[][] array,int left, int right, int up, int down){
    	if(left>right)
    		return;
    	for(int i=left;i<=right;i++)
    		System.out.print(array[up][i]+" ");
    	up++;
    	UtoD(array,left, right, up, down);
    }
    public static void UtoD(String[][] array,int left, int right, int up, int down){
    	if(up>down)
    		return;
    	for(int i=up;i<=down;i++)
    		System.out.print(array[i][right]+" ");
    	right--;
    	RtoL(array,left, right, up, down);
    }
    public static void RtoL(String[][] array,int left, int right, int up, int down){
    	if(left>right)
    		return;
    	for(int i=right;i>=left;i--)
    		System.out.print(array[down][i]+" ");
    	down--;
    	DtoU(array,left, right, up, down);
    }
    public static void DtoU(String[][] array,int left, int right, int up, int down){
    	if(up>down)
    		return;
    	for(int i=down;i>=up;i--)
    		System.out.print(array[i][left]+" ");
    	left++;
    	LtoR(array,left, right, up, down);
    }
}

