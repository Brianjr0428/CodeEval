import java.io.*;
import java.math.BigDecimal;

public class cashRegister{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] content;
			double price;
			double cash;
			double diff;
			while ((line = in.readLine()) != null){	
				content = line.split(";");
				price=Double.parseDouble(content[0]);
				cash=Double.parseDouble(content[1]);
				diff=sub(cash,price);
				System.out.println(change(diff));
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static String change(double change){
		if(change<0)
			return "ERROR";
		if(change==0)
			return "ZERO";
		String result="";
		while(change>=0.01){
			if(change>=100){
				if(result=="")
					result+="ONE HUNDRED";
				else
					result+=",ONE HUNDRED";
				change-=100;
			}
			else if(change>=50){
				if(result=="")
					result+="FIFTY";
				else
					result+=",FIFTY";
				change-=50;
			}
			else if(change>=20){
				if(result=="")
					result+="TWENTY";
				else
					result+=",TWENTY";
				change-=20;
			}
			else if(change>=10){
				if(result=="")
					result+="TEN";
				else
					result+=",TEN";
				change-=10;
			}
			else if(change>=5){
				if(result=="")
					result+="FIVE";
				else
					result+=",FIVE";
				change-=5;
			}
			else if(change>=2){
				if(result=="")
					result+="TWO";
				else
					result+=",TWO";
				change-=2;
			}
			else if(change>=1){
				if(result=="")
					result+="ONE";
				else
					result+=",ONE";
				change-=1;
			}
			else if(change>=0.5){
				if(result=="")
					result+="HALF DOLLAR";
				else
					result+=",HALF DOLLAR";
				change=sub(change,0.5);
			}
			else if(change>=0.25){
				if(result=="")
					result+="QUARTER";
				else
					result+=",QUARTER";
				change=sub(change,0.25);
			}
			else if(change>=0.1){
				if(result=="")
					result+="DIME";
				else
					result+=",DIME";
				change=sub(change,0.1);
			}
			else if(change>=0.05){
				if(result=="")
					result+="NICKEL";
				else
					result+=",NICKEL";
				change=sub(change,0.05);
			}
			else if(change>=0.01){
				if(result=="")
					result+="PENNY";
				else
					result+=",PENNY";
				change=sub(change,0.01);
			}
		}
		return result;
	}
	public static double sub(double d1, double d2){
		BigDecimal b1=new BigDecimal(Double.toString(d1));
		BigDecimal b2=new BigDecimal(Double.toString(d2));
		return b1.subtract(b2).doubleValue();
	}
}
