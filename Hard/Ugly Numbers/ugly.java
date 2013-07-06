import java.io.*;
public class ugly {
	public static int count;
	public static void main (String[] args) throws IOException{
		//read the text file
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null){	
			count=0;	
			ugly(0, '+', line, 0, 0);
			System.out.println(count);
		}
	}
	public static boolean uglyNumber(double x){
		if(x%2==0||x%3==0||x%5==0||x%7==0)
			return true;
		else
			return false;
	}
	public static void ugly(double preNum, char oprand, String str, int begin, int curr){
		double newNum;
		if(curr==str.length()-1){
			newNum = Double.parseDouble(str.substring(begin, curr+1));
			if(oprand=='+')
				preNum+=newNum;
			else if(oprand=='-')
				preNum-=newNum;
			if(uglyNumber(preNum)){
				count++;
			}
		}
		else{
			ugly(preNum, oprand, str, begin, curr+1);
			if(oprand=='+'){
				newNum = Integer.parseInt(str.substring(begin, curr+1));
				preNum+=newNum;
				ugly(preNum, '+', str, curr+1, curr+1);
				ugly(preNum, '-', str, curr+1, curr+1);
			}
			else if(oprand=='-'){
				newNum = Integer.parseInt(str.substring(begin, curr+1));
				preNum-=newNum;
				ugly(preNum, '+', str, curr+1, curr+1);
				ugly(preNum, '-', str, curr+1, curr+1);
			}
		}		
	}
}
