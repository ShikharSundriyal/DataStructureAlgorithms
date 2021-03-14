import java.io.*;
import java.util.*;

public class Main{
  
 public static int precedence(char ch){
    if(ch == '*' || ch == '/')
        return 2;
    else if(ch == '+' || ch == '-')
        return 1;
    return 0;
      
 } 
 public static String postfix(String exp){
     
    Stack<Character> operator = new Stack<>();
    Stack<String> operand = new Stack<>();
    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        if(ch == ' '){
        }
        else if(ch == '('){
            operator.push(ch);
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operator.size() > 0 && precedence(operator.peek()) >= precedence(ch) ){
                String val2 = operand.pop();
                String val1 = operand.pop();
                char opera = operator.pop();
                String res = val1 + val2+ opera;
                operand.push(res);
            }
            operator.push(ch);
        }else if(ch == ')'){
            while(operator.size()>0 && operator.peek() != '('){
                String val2 = operand.pop();
                String val1 = operand.pop();
                char opera = operator.pop();
                String res = val1 + val2 + opera;
                operand.push(res);
            }
            operator.pop();
        }
        else{
            operand.push(ch+"");
        }
    }
    while(operator.size()>0){
        String val2 = operand.pop();
        String val1 = operand.pop();
        char opera = operator.pop();
        String res = val1 + val2+ opera;
        operand.push(res);
    }
    return operand.peek();
 }
 public static String prefix(String exp){

    Stack<Character> operator = new Stack<>();
    Stack<String> operand = new Stack<>();
    for(int i=0;i<exp.length();i++){
        char ch = exp.charAt(i);
        if(ch == ' '){
        }
        else if(ch == '('){
            operator.push(ch);
        }else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operator.size() > 0 && precedence(operator.peek()) >= precedence(ch) ){
                String val2 = operand.pop();
                String val1 = operand.pop();
                char opera = operator.pop();
                String res = opera + val1 + val2;
                operand.push(res);
            }
            operator.push(ch);
        }else if(ch == ')'){
            while(operator.size()>0 && operator.peek() != '('){
                String val2 = operand.pop();
                String val1 = operand.pop();
                char opera = operator.pop();
                String res = opera + val1 + val2;
                operand.push(res);
            }
            operator.pop();
        }
        else{
            operand.push(ch+"");
        }
    }
    while(operator.size()>0){
        String val2 = operand.pop();
        String val1 = operand.pop();
        char opera = operator.pop();
        String res = opera + val1 + val2;
        operand.push(res);
    }
    return operand.peek();
 }  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    System.out.println(postfix(exp));
    System.out.println(prefix(exp));
    // code
 }
}