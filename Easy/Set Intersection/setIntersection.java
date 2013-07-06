import java.io.*;

public class setIntersection{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			while ((line = in.readLine()) != null){	
				String[] groups=line.split(";");
				String[] group1=groups[0].split(",");
				String[] group2=groups[1].split(",");
				int index1=0;
				int index2=0;
				String result="";
				while(index1<group1.length&&index2<group2.length){
					if(Integer.parseInt(group1[index1])<Integer.parseInt(group2[index2]))
						index1++;
					else if (Integer.parseInt(group1[index1])>Integer.parseInt(group2[index2]))
						index2++;
					else if (Integer.parseInt(group1[index1])==Integer.parseInt(group2[index2])){
						if(result=="")
							result+=group1[index1];
						else
							result=result+","+group1[index1];
						index1++;
						index2++;
					}	
				}
				System.out.println(result);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}