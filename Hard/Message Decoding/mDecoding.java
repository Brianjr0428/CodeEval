import java.io.*;

public class mDecoding {
	public static void main (String[] args)throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){
			String msg;
			String key;
			String len;
			int index=0;
			while(line.charAt(index)!='0'&&line.charAt(index)!='1'){
				index++;
			}
			msg=line.substring(0,index);
			key=line.substring(index);
			index=0;
			while(index<key.length()){
				len=key.substring(index,index+3);
				index+=3;
				if(len.equals("000"))
					break;
				else if(len.equals("001"))
					index=lOne(index, key,msg);
				else if(len.equals("010"))
					index=lTwo(index, key,msg);
				else if(len.equals("011"))
					index=lThree(index, key,msg);
			}
			System.out.println();
		}
	}
	public static int lOne(int index, String key,String msg){
		while(key.charAt(index)!='1'){
			if(key.charAt(index)=='0')
				System.out.print(msg.charAt(0));
			index++;
		}
		index++;
		return index;
	}
	public static int lTwo(int index, String key,String msg){
		while(!key.substring(index,index+2).equals("11")){
			if(key.substring(index,index+2).equals("00"))
				System.out.print(msg.charAt(1));
			else if(key.substring(index,index+2).equals("01"))
				System.out.print(msg.charAt(2));
			else if(key.substring(index,index+2).equals("10"))
				System.out.print(msg.charAt(3));
			index+=2;
		}
		index+=2;
		return index;
	}
	public static int lThree(int index, String key,String msg){
		while(!key.substring(index,index+3).equals("111")){
			if(key.substring(index,index+3).equals("000"))
				System.out.print(msg.charAt(4));
			else if(key.substring(index,index+3).equals("001"))
				System.out.print(msg.charAt(5));
			else if(key.substring(index,index+3).equals("010"))
				System.out.print(msg.charAt(6));
			else if(key.substring(index,index+3).equals("011"))
				System.out.print(msg.charAt(7));
			else if(key.substring(index,index+3).equals("100"))
				System.out.print(msg.charAt(8));
			else if(key.substring(index,index+3).equals("101"))
				System.out.print(msg.charAt(9));
			else if(key.substring(index,index+3).equals("110"))
				System.out.print(msg.charAt(10));
			index+=3;
		}
		index+=3;
		return index;
	}
}
