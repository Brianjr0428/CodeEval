import java.io.*;

public class penultimateWord{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			//String[] content=line.split(" ");
			//System.out.println(content[content.length-2]);
			int end=-1;
			int start=0;
			int index=line.length()-1;
			while(index>=0){
				if(line.charAt(index)==' '){
					if (end==-1)
						end=index;
					else{
						start=index+1;
						break;
					}
				}
				index--;
			}
			for(int i=start;i<end;i++)
				System.out.print(line.charAt(i));
			System.out.println();
		}
	}
}