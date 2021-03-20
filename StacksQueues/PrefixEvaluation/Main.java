import java.io.*;
import java.util.*;

public class Main{
    public static int operate(int val1,int val2,char operator){
     int res =0; 
      if(operator == '+'){
        return val1+val2;
      }
    else if(operator == '-'){
        return val1-val2;
    }
    else if(operator == '*'){
        return val1*val2;
    }
    else if(operator == '/'){
        return val1/val2;
    }
    return res;
    
  }
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
    
    public static int calulateValue(String exp){
        Stack<Integer> st = new Stack();
      for(int i=exp.length()-1;i>=0;i--){
          char ch = exp.charAt(i);
          if(ch == '*' || ch == '+' || ch == '-' || ch == '/'){
              int val1 = st.pop();
              int val2 = st.pop();
              int res = operate(val1,val2,ch);
              st.push(res);
          }else if(ch>='0' && ch<='9'){
              st.push(Integer.parseInt(ch+""));
          }
      }
      return st.peek();
    }
  
  public static String infix(String exp){
      Stack<String> st = new Stack();
      for(int i=exp.length()-1;i>=0;i--){
          char ch = exp.charAt(i);
          if(ch == '*' || ch == '+' || ch == '-' || ch == '/'){
              String val1 = st.pop();
              String val2 = st.pop();
              String res = "("+val1 +ch+val2+")";
              st.push(res);
          }else if(ch>='0' && ch<='9'){
              st.push(ch+"");
          }
      }
      return st.peek();
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    System.out.println(calulateValue(exp));
    String infix = infix(exp);
    System.out.println(infix);
    System.out.println(postfix(infix));
    // code
 }
}