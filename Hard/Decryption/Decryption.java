public class Decryption {
	public static void main(String argv[]){
		String msg="012222 1114142503 0313012513 03141418192102 0113 2419182119021713 06131715070119";
		String key="BHISOECRTMGWYVALUZDNFJKPQX";
		int i=0;
		int value;
		String result="";
		while(i<msg.length()){
			if(msg.charAt(i)==' '){
				result+=" ";
				i++;
			}
			else{
				value=msg.charAt(i)-'0';
				i++;
				value*=10;
				value+=msg.charAt(i)-'0';
				i++;
				result+=(char)('A'+findIndex((char)('A'+value),key));
			}
		}
		System.out.println(result);
	}
	public static int findIndex(char c,String key){
		for(int i=0;i<key.length();i++){
			if(c==key.charAt(i))
				return i;	
		}
		return -1;
	}
}
