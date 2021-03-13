import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Stack<Integer> operand = new Stack<>();
    Stack<Character> operator = new Stack<>();
    
    for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);
        if(ch == ' '){
			
		}
		else if(ch == '('){
            operator.push(ch);
        }else if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
            
            while(operator.size()>0 && precedence(operator.peek()) >= precedence(ch) ){
                char oper = operator.pop();
                int op2 = operand.pop();
                int op1 = operand.pop();
                int res = calculate(op1,op2,oper);
				
                operand.push(res);
            }
            operator.push(ch);
        }else if(ch == ')'){
            while(operator.size()>0 && operator.peek() != '(') {
                char oper = operator.pop();
                int op2 = operand.pop();
                int op1 = operand.pop();
                int res = calculate(op1,op2,oper);
                operand.push(res);
            }
            operator.pop();
        }else{
            operand.push(ch-'0');
        }
    }
    while(operator.size() > 0){
        char oper = operator.pop();
        int op2 = operand.pop();
        int op1 = operand.pop();
        int res = calculate(op1,op2,oper);
        operand.push(res);
    }
    
    System.out.println(operand.peek());
    // code
 }
 
 public static int calculate(int op1,int op2, char ch){
     if(ch == '+')
         return op1+op2;
     else if(ch ==  '-')
         return op1-op2;
     else if(ch == '*') 
		return op1*op2;
     else 
		 return op1/op2;
 }
 public static int precedence(char ch){
     if(ch== '+' || ch == '-') 
		 return 1;
     else if(ch == '*' || ch == '/') 
		 return 2;
     else 
		 return 0;
 }
}