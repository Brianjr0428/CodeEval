import java.io.*;

public class rightmostChar{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			int index=-1;
			String[] content=line.split(",");
			char t=content[1].charAt(0);
			for(int i=0;i<content[0].length();i++){
				if(t==content[0].charAt(i))
					index=i;
			}
			System.out.println(index);
		}
	}
}