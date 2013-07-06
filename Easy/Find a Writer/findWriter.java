import java.io.*;

public class findWriter{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			if(!line.isEmpty()){
				String sentence="";
				String numStr="";
				for(int i=0;i<line.length();i++){
					if(line.charAt(i)=='|'){
						sentence=line.substring(0,i);
						numStr=line.substring(i+2);
					}
				}
				String[] nums=numStr.split(" ");
				for(int i=0;i<nums.length;i++)
					System.out.print(sentence.charAt(Integer.parseInt(nums[i])-1));
				System.out.println();
			}			
		}
	}
}