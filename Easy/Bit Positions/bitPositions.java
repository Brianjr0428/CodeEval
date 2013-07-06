import java.io.*;

public class bitPositions{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] content;
			int num;
			int pos1;
			int pos2;
			String dToB;
			while ((line = in.readLine()) != null){
				content=line.split(",");
				num=Integer.parseInt(content[0]);
				pos1=Integer.parseInt(content[1]);
				pos2=Integer.parseInt(content[2]);
				dToB="0";
				while(num>0){
					if(num%2==1){
						dToB="1"+dToB.substring(1);
						num-=1;
					}
					else{
						dToB="0"+dToB;
						num/=2;
					}
				}
				System.out.println(dToB.charAt(dToB.length()-pos1)==dToB.charAt(dToB.length()-pos2));
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
