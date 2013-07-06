import java.io.*;
import java.util.Stack;
import java.util.ArrayList;
public class simpleCalculator{
	public static void main (String[] args) throws IOException{
		java.text.DecimalFormat nf = new java.text.DecimalFormat("#.#####");
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line; 
		while ((line = in.readLine()) != null){
			String newLine="";
			for(int i=0;i<line.length();i++){
				if(line.charAt(i)!=' ')
					newLine+=line.charAt(i);
			}
			ArrayList<String> prefixExp= new ArrayList<String>();
			Stack<Character> operatorStack=new Stack<Character>();
			int index=newLine.length()-1;
			while(index>=0){
				int headIndex=0;
				if(isOperator(newLine.charAt(index))){
					if((newLine.charAt(index)=='-')&&(index==0||newLine.charAt(index-1)=='^'||newLine.charAt(index-1)=='*'||newLine.charAt(index-1)=='/'||newLine.charAt(index-1)=='(')){
						prefixExp.add(Integer.toString(0));
						prefixExp.add(Character.toString('-'));
					}
					else{
						if(operatorStack.isEmpty())
							operatorStack.push(newLine.charAt(index));
						else{
							if(newLine.charAt(index)=='^')
								operatorStack.push(newLine.charAt(index));
							else if(newLine.charAt(index)=='*'||newLine.charAt(index)=='/'){
								while(!operatorStack.isEmpty()&&(operatorStack.peek()=='^'))
									prefixExp.add(Character.toString(operatorStack.pop()));
								operatorStack.push(newLine.charAt(index));
							}
							else if(newLine.charAt(index)=='+'||newLine.charAt(index)=='-'){
								while(!operatorStack.isEmpty()&&(operatorStack.peek()=='*'||operatorStack.peek()=='/'||operatorStack.peek()=='^'))
									prefixExp.add(Character.toString(operatorStack.pop()));
								operatorStack.push(newLine.charAt(index));
							}
							else if(newLine.charAt(index)==')')
								operatorStack.push(newLine.charAt(index));
							else if(newLine.charAt(index)=='('){
								while(operatorStack.peek()!=')')
									prefixExp.add(Character.toString(operatorStack.pop()));
								operatorStack.pop();
							}
						}
					}
					index--;
				}
				else{
					headIndex=findNumIndex(newLine, index);
					prefixExp.add(newLine.substring(headIndex, index+1));
					index=headIndex-1;
				}
			}
			while(!operatorStack.isEmpty())
				prefixExp.add(Character.toString(operatorStack.pop()));
			Stack<Double> operandStack=new Stack<Double>();
			double num1;
			double num2;
			for(int i=0;i<prefixExp.size();i++){
				if(prefixExp.get(i).equals("^")){
					num1=operandStack.pop();
					num2=operandStack.pop();
					operandStack.push(Math.pow(num1, num2));
				}
				else if(prefixExp.get(i).equals("*")){
					num1=operandStack.pop();
					num2=operandStack.pop();
					operandStack.push(num1*num2);
				}
				else if(prefixExp.get(i).equals("/")){
					num1=operandStack.pop();
					num2=operandStack.pop();
					operandStack.push(num1/num2);
				}
				else if(prefixExp.get(i).equals("+")){
					num1=operandStack.pop();
					num2=operandStack.pop();
					operandStack.push(num1+num2);
				}
				else if(prefixExp.get(i).equals("-")){
					num1=operandStack.pop();
					num2=operandStack.pop();
					operandStack.push(num1-num2);
				}
				else
					operandStack.push(Double.parseDouble(prefixExp.get(i)));
			}
			System.out.println(nf.format(operandStack.pop()));
		}
	}
	public static boolean isOperator(char c){
		return (c=='('||c==')'||c=='-'||c=='+'||c=='*'||c=='/'||c=='^');
	}
	public static int findNumIndex(String str, int index){
		while(index!=0&&!isOperator(str.charAt(index-1)))
			index--;
		return index;
	}
}