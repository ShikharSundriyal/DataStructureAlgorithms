class DuplicateBracketQuestion{
public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> st = new Stack<>();
		for(int i=0; i < str.length(); i++){
			char ch = str.charAt(i);
			if(ch != ')'){
				st.push(ch);
			}else{
				if(st.size()>0 && st.peek() == '('){
					System.out.println("true");
					return;
				}else{
					while(st.peek() != '('){
						st.pop();
					}
					st.pop();
				}
			}
		}
		System.out.println("false");
		
}
}