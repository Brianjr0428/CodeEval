import java.io.*;

public class arrayAbsurdity{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		int[] result;
		int num;
		String[] content;
		String[] numbers;
		while ((line = in.readLine()) != null){	
			if(!line.equals("")){
				content=line.split(";");
				numbers=content[1].split(",");
				num=Integer.parseInt(content[0]);
				result=new int[num];
				for(int i=0;i<result.length;i++)
					result[i]=Integer.parseInt(numbers[i]);
				result=mergeSort(result,0,result.length-1);
				for(int i=0;i<result.length-1;i++){
					if(result[i]==result[i+1]){
						System.out.println(result[i]);
						break;
					}
				}
			}
		}
	}
	public static int[] mergeSort(int[] arr, int start, int end){
		if(start==end){
			int[] result={arr[start]};
			return result;
		}
		int mid = (start+end)/2;
		return merge(mergeSort(arr,start,mid), mergeSort(arr,mid+1,end));
	}
	public static int[] merge(int[] arr1, int[] arr2){
		int[] result=new int[arr1.length+arr2.length];
		int index=0;
		int index1=0;
		int index2=0;
		while(index<result.length){
			if(index1==arr1.length){
				while(index2<arr2.length){
					result[index]=arr2[index2];
					index++;
					index2++;
				}
			}
			else if(index2==arr2.length){
				while(index1<arr1.length){
					result[index]=arr1[index1];
					index++;
					index1++;
				}
			}
			else{
				if(arr1[index1]<=arr2[index2]){
					result[index]=arr1[index1];
					index++;
					index1++;
				}
				else{
					result[index]=arr2[index2];
					index++;
					index2++;
				}		
			}
		}
		return result;
	}
}
