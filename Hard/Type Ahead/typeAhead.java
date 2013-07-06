import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.text.DecimalFormat;
public class typeAhead{
	
	public static void main (String[] args){
		try{
			//read the text file
			File file = new File(args[0]);
			String textFile ="Mary had a little lamb its fleece was white as snow; And everywhere that Mary went, the lamb was sure to go. It followed her to school one day, which was against the rule;It made the children laugh and play, to see a lamb at school.And so the teacher turned it out, but still it lingered near,And waited patiently about till Mary did appear.\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";
			String[] content=textFile.split("[ .\";?,]+");
			BufferedReader in = new BufferedReader(new FileReader(file));
			HashMap<String, Integer> hash=new HashMap<String, Integer> ();
			String line; 
			int nGramLen;
			double sum;
			String word;
			while ((line = in.readLine()) != null){	
				sum=0;
				hash.clear();
				String[] nGram=line.split(",");
				String[] nGramContent=nGram[1].split(" ");
				nGramLen=Integer.parseInt(nGram[0]);
				for(int i=0;i<content.length-nGramLen+1;i++){
					if(matchGram(content,nGramContent,i)){
						word=content[i+nGramLen-1];
						if(!hash.containsKey(word))
							hash.put(word, 1);
						else
							hash.put(word, hash.get(word)+1);
					}
				}
				List<Map.Entry<String, Integer>> listData= new ArrayList<Map.Entry<String, Integer>>(hash.entrySet());
				Collections.sort(listData, new Comparator<Map.Entry<String, Integer>>(){
					 public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2){
							 return (entry1.getKey().compareTo(entry2.getKey()));
							 }
				});
				Collections.sort(listData, new Comparator<Map.Entry<String, Integer>>(){
					 public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2){
							 return (entry2.getValue().compareTo(entry1.getValue()));
							 }
				});
				for(Map.Entry<String, Integer> s:listData)
					sum+=s.getValue();
				int count=0;
				for(Map.Entry<String, Integer> s:listData){
					count++;
					if(count!=listData.size())
						System.out.print(s.getKey()+","+new java.text.DecimalFormat("0.000").format(s.getValue()/sum)+";");
					else
						System.out.println(s.getKey()+","+new java.text.DecimalFormat("0.000").format(s.getValue()/sum));
				}				
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}	
	}
	public static boolean matchGram(String[] content, String[] grams,int index){
		if(content.length<grams.length)
			return false;
		int len=grams.length;
		for(int i=0;i<len;i++){
			if(!content[index+i].equals(grams[i]))
				return false;
		}
		return true;
	}

}
