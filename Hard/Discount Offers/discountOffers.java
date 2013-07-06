import java.io.*;

public class discountOffers{
	static double maxSum;
	static int x;
	static int y;
	public static void main (String[] args) throws IOException{
		java.text.DecimalFormat nf = new java.text.DecimalFormat("0.00");
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){
			x=-1;
			y=-1;
			maxSum=0;
			String content[]=line.split(";");
			String customers[]=content[0].split(",");
			String products[]=content[1].split(",");
			int upperBound=Math.min(products.length, customers.length);
			double matrix[][]=new double[products.length][customers.length];
			for(int i=0;i<products.length;i++){
				for(int j=0;j<customers.length;j++)
					matrix[i][j]=calculateSS(products[i],customers[j]);
			}
			double newMatrix[][]=new double[products.length][customers.length];
			double max=Double.MIN_VALUE;
			double min=Double.MAX_VALUE;
			for(int i=0;i<products.length;i++){
				for(int j=0;j<customers.length;j++)
					if(matrix[i][j]>max)
						max=matrix[i][j];
			}
			for(int i=0;i<products.length;i++){
				for(int j=0;j<customers.length;j++)
					newMatrix[i][j]=0-matrix[i][j]+max;
			}
			
			//step 1
			for(int i=0;i<newMatrix.length;i++){
				min=Double.MAX_VALUE;
				for(int j=0;j<newMatrix[0].length;j++){
					if(newMatrix[i][j]<min)
						min=newMatrix[i][j];
				}
				for(int j=0;j<newMatrix[0].length;j++)
						newMatrix[i][j]-=min;
			}
			boolean starMatrix[][]=new boolean[newMatrix.length][newMatrix[0].length];
			boolean primeMatrix[][]=new boolean[newMatrix.length][newMatrix[0].length];
			boolean[] rows=new boolean[newMatrix.length];
			boolean[] cols=new boolean[newMatrix[0].length];
			
			//step 2
			for(int i=0;i<newMatrix.length;i++){
				for(int j=0;j<newMatrix[0].length;j++){
					if(newMatrix[i][j]==0&&!rows[i]&&!cols[j]){
						starMatrix[i][j]=true;
						rows[i]=true;
						cols[j]=true;
					}
				}
			}
			for(int i=0;i<rows.length;i++)
				rows[i]=false;
			for(int i=0;i<cols.length;i++)
				cols[i]=false;
			
			int step=3;
			while(step!=7){
				switch(step){
				case 3:
					step=step3(upperBound, primeMatrix,starMatrix, newMatrix,rows,cols);
					break;
				case 4:
					step=step4(upperBound,primeMatrix, starMatrix, newMatrix,rows,cols);
					break;
				case 5:
					step=step5(upperBound,x,y,primeMatrix, starMatrix, newMatrix,rows,cols);
					break;
				case 6:
					step=step6(upperBound,primeMatrix, starMatrix, newMatrix,rows,cols);
					break;
				}
			}
			
			//step 3
			step3(upperBound, primeMatrix,starMatrix, newMatrix,rows,cols);
			
			
			
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[0].length;j++){
					if(starMatrix[i][j]){
						for(int k=0;k<matrix.length;k++){
							if(matrix[k][j]>matrix[i][j]&&!checkStarRow(starMatrix, k)){
								starMatrix[k][j]=true;
								starMatrix[i][j]=false;
								break;
							}
						}
					}
				}
			}
			
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[0].length;j++){
					if(starMatrix[i][j])
						maxSum+=matrix[i][j];
				}
			}
			System.out.println(nf.format(maxSum));
		}
	}
	public static int step3(int upperBound,boolean primeMatrix[][],boolean starMatrix[][], double newMatrix[][],boolean[] rows,boolean[] cols){
		crossCol(starMatrix, newMatrix,rows,cols);
		if(countCol(cols)!=upperBound)
			return 4;
		else 
			return 7;
	}
	public static int step4(int upperBound,boolean primeMatrix[][], boolean starMatrix[][], double newMatrix[][],boolean[] rows,boolean[] cols){
		for(int i=0;i<newMatrix.length;i++){
			for(int j=0;j<newMatrix[0].length;j++){
				if(newMatrix[i][j]==0&&!rows[i]&&!cols[j]){
					primeMatrix[i][j]=true;
					if(!checkStarRow(starMatrix, i)){
						x=i;
						y=j;
						return 5;
					}
					else{
						for(int k=0;k<starMatrix[0].length;k++){
							if(starMatrix[i][k]){
								rows[i]=true;
								cols[k]=false;
								return 4;
							}
						}
					}
				}
			}
		}
		return 6;
	}
	public static int step5(int upperBound,int row, int col,boolean primeMatrix[][],boolean starMatrix[][], double newMatrix[][],boolean[] rows,boolean[] cols){
		if(!checkPrime(starMatrix, row, col)){
			starMatrix[row][col]=true;
			for(int i=0;i<rows.length;i++){
				for(int j=0;j<cols.length;j++)
					primeMatrix[i][j]=false;
			}
			for(int i=0;i<rows.length;i++)
				rows[i]=false;
			for(int j=0;j<cols.length;j++)
				cols[j]=false;
			return 3;
		}
		else{
			for(int i=0;i<rows.length;i++){
				if(starMatrix[i][col]){
					starMatrix[row][col]=true;
					starMatrix[i][col]=false;
					for(int j=0;j<cols.length;j++){
						if(primeMatrix[i][j]){
							x=i;
							y=j;
							return 5;
						}
					}
				}	
			}
		}
		return -1;
	}
	public static int step6(int upperBound,boolean primeMatrix[][],boolean starMatrix[][], double newMatrix[][],boolean[] rows,boolean[] cols){
		double minValue=Double.MAX_VALUE;
		for(int i=0;i<newMatrix.length;i++){
			for(int j=0;j<newMatrix[0].length;j++){
				if(!rows[i]&&!cols[j]){
					if(newMatrix[i][j]<minValue)
						minValue=newMatrix[i][j];
				}
			}
		}
		for(int i=0;i<newMatrix.length;i++){
			for(int j=0;j<newMatrix[0].length;j++){
				if(rows[i])
					newMatrix[i][j]+=minValue;
				if(!cols[j])
					newMatrix[i][j]-=minValue;
			}
		}
		return 4;
	}
	public static boolean checkPrime(boolean[][] starMatrix, int row, int col){
		for(int i=0;i<starMatrix.length;i++){
			if(i==row)
				continue;
			else{
				if(starMatrix[i][col])
					return true;
			}
		}
		return false;
	}
	public static boolean checkStarRow(boolean starMatrix[][], int row){
		for(int i=0;i<starMatrix[0].length;i++){
			if(starMatrix[row][i])
				return true;
		}
		return false;
	}
	public static boolean checkStar(boolean starMatrix[][], int row, int col){
		for(int j=0;j<starMatrix[0].length;j++){
			if(j==col)
				continue;
			else{
				if(starMatrix[row][j])
					return false;
			}
		}
		for(int i=0;i<starMatrix.length;i++){
			if(i==row)
				continue;
			else{
				if(starMatrix[i][col])
					return false;
			}
		}
		return true;
	}
	public static void crossCol(boolean starMatrix[][], double newMatrix[][],boolean[] rows,boolean[] cols){
		for(int i=0;i<newMatrix.length;i++){
			for(int j=0;j<newMatrix[0].length;j++){
				if(starMatrix[i][j])
					cols[j]=true;
			}
		}
	}
	public static int countCol(boolean[] cols){
		int count=0;
		for(int i=0;i<cols.length;i++){
			if(cols[i])
				count++;
		}
		return count;
	}
	public static void printMatrix(boolean[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++)
				System.out.format("%6s",matrix[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	public static void printMatrix(double[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++)
				System.out.format("%6s",matrix[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	public static boolean commonFactor(int num1, int num2){
		if(num1==1||num2==1)
			return false;
		if(num1==2&&num2==2)
			return false;
		for(int i=2;i<=Math.min(num1, num2);i++){
			if(num1%i==0&&num2%i==0)
				return true;
		}
		return false;
	}
	public static double calculateSS(String product, String customer){
		double ss=0;
		if(isEven(numOfLetters(product)))
			ss=vowels(customer)*1.5;
		else
			ss=consonants(customer);
		if(commonFactor(numOfLetters(product),numOfLetters(customer)))
			ss*=1.5;
		return ss;
	}
	public static boolean isEven(int x){
		return (x%2==0);
	}
	public static int numOfLetters(String str){
		int count=0;
		for(int i=0;i<str.length();i++){
			if((str.charAt(i)>=65&&str.charAt(i)<=90)||(str.charAt(i)>=97&&str.charAt(i)<=122))
				count++;
		}
		return count;
	}
	public static int vowels(String str){
		int count=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>=65&&str.charAt(i)<=90){
				if(str.charAt(i)==65||str.charAt(i)==69||str.charAt(i)==73
						||str.charAt(i)==79||str.charAt(i)==85||str.charAt(i)==89)
				count++;
			}
			if(str.charAt(i)>=97&&str.charAt(i)<=122){
				if(str.charAt(i)==97||str.charAt(i)==101||str.charAt(i)==105
						||str.charAt(i)==111||str.charAt(i)==117||str.charAt(i)==121)
				count++;
			}	
		}
		return count;
	}
	public static int consonants (String str){
		int count=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>=65&&str.charAt(i)<=90){
				if(str.charAt(i)!=65&&str.charAt(i)!=69&&str.charAt(i)!=73
						&&str.charAt(i)!=79&&str.charAt(i)!=85&&str.charAt(i)!=89)
				count++;
			}
			if(str.charAt(i)>=97&&str.charAt(i)<=122){
				if(str.charAt(i)!=97&&str.charAt(i)!=101&&str.charAt(i)!=105
						&&str.charAt(i)!=111&&str.charAt(i)!=117&&str.charAt(i)!=121)
				count++;
			}	
		}
		return count;
	}
}