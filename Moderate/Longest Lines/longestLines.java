import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class longestLines{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			boolean firstLine=false;
			ArrayList<String> lines=new ArrayList<String>();
			int n=0;
			int longest=0;
			int longIndex=0;
			while ((line = in.readLine()) != null){	
				if(!firstLine){
					n=Integer.parseInt(line);
					firstLine=true;
				}
				else
					lines.add(line);
			}
			Collections.sort(lines);
			for(int i=0;i<n;i++){
				longest=0;
				longIndex=0;
				for(int j=0;j<lines.size();j++){
					if(lines.get(j).length()>longest){
						longIndex=j;
						longest=lines.get(j).length();
					}
				}
				System.out.println(lines.get(longIndex));
				lines.remove(longIndex);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
