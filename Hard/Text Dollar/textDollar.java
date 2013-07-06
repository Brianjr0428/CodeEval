import java.io.*;

public class textDollar{
	static String[]  belowTwenty={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
						"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	static String[] tenDigit={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		int convertNum=0;
		int tempNum=0;
		while ((line = in.readLine()) != null){
			String result="";
			convertNum=Integer.parseInt(line);
			tempNum=convertNum%1000;
			result=numToStr(tempNum);
			if(convertNum>1000){
				tempNum=convertNum/1000%1000;
				if(tempNum>0)
					result=numToStr(tempNum)+"Thousand"+result;
			}
			if(convertNum>1000000){
				tempNum=convertNum/1000000;
				result=numToStr(tempNum)+"Million"+result;
			}
			if(result.equals("One"))
				result+="Dollar";
			else
				result+="Dollars";
				
			System.out.println(result);
		}
	}
	public static String numToStr(int num){
		String result="";
		if(num%100<20){
			result=belowTwenty[num%100]+result;
			num/=100;
		}
		else{
			result=belowTwenty[num%10]+result;
			num/=10;
			result=tenDigit[num%10]+result;
			num/=10;
		}
		if(num>0)
			result=belowTwenty[num%10]+"Hundred"+result;
		return result;
	}
}
