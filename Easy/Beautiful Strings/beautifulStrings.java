import java.io.*;
import java.util.Arrays;

public class beautifulStrings{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){
			int sum=0;
			int[] table=makeTable(line);
			Arrays.sort(table);
			int num=26;
			int index=table.length-1;
			while(index>-1&&table[index]!=0){
				sum+=num*table[index];
				num--;
				index--;
			}
			System.out.println(sum);
		}
	}
	public static int[] makeTable(String str){
		int[] table=new int[26];
		for(int i=0;i<table.length;i++)
			table[i]=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>=65&&str.charAt(i)<=90)
				table[str.charAt(i)-65]++;
			else if (str.charAt(i)>=97&&str.charAt(i)<=122)
				table[str.charAt(i)-97]++;
		}
		return table;
	}
}