import java.io.*;

public class fIntegers {
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		int index;
		while ((line = in.readLine()) != null){	
			index = line.length()-1;
			while(index>0){
				if(Character.getNumericValue(line.charAt(index-1))<Character.getNumericValue(line.charAt(index))){
					findNext(line,index-1);
					break;
				}
				index--;
			}
			if(index==0)
				findAddOne(line);
		}
	}
	public static void findNext(String str, int index){
		int tmp=str.length()-1;;
		for(int i=0;i<index;i++)
			System.out.print(str.charAt(i));
		while(Character.getNumericValue(str.charAt(index))>=Character.getNumericValue(str.charAt(tmp)))
				tmp--;
		System.out.print(str.charAt(tmp));
		for(int i=str.length()-1;i>index;i--){
			if(i==tmp)
				System.out.print(str.charAt(index));
			else
				System.out.print(str.charAt(i));
		}
		System.out.println();
	}
	public static void findAddOne(String str){
		int index=str.length()-1;
		while(index>=0){
			if(str.charAt(index)!='0')
				break;
			index--;
		}
		System.out.print(str.charAt(index));
		System.out.print("0");
		for(int i=str.length()-1;i>=0;i--){
			if(i!=index)
				System.out.print(str.charAt(i));
		}
		System.out.println();
	}
}
