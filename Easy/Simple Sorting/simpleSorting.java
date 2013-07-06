import java.io.*;

public class simpleSorting{
	public static void main (String[] args) throws IOException{
		java.text.DecimalFormat nf = new java.text.DecimalFormat("0.000");
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){	
			String[] content=line.split(" ");
			double[] numbers=new double[content.length];
			for(int i=0;i<numbers.length;i++)
				numbers[i]=Double.parseDouble(content[i]);
			double[] result=mergeSort(numbers,0,numbers.length-1);
			for(double d:result)
				System.out.print(nf.format(d)+" ");
			System.out.println();
		}
	}
	public static double[] mergeSort(double[] array, int start, int end){
		if(start==end){
			double[] result=new double[1];
			result[0]=array[start];
			return result;
		}
		else{
			int mid=(start+end)/2;
			return merge(mergeSort(array, start,mid), mergeSort(array,mid+1, end));
		}
			
			
		
	}
	public static double[] merge(double[] arr1, double[] arr2){
		double[] result=new double[arr1.length+arr2.length];
		int index1=0;
		int index2=0;
		int index=0;
		while(index<result.length){
			if(index1==arr1.length){
				while(index2<arr2.length){
					result[index]=arr2[index2];
					index2++;
					index++;
				}	
			}
			else if(index2==arr2.length){
				while(index1<arr1.length){
					result[index]=arr1[index1];
					index1++;
					index++;
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