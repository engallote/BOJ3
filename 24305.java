import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	Stack<Pair> st = new Stack<>();
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i <= N; i++) {
    		int num = sc.nextInt();
    		
    		if(i == 1) {
    			sb.append("0 ");
    			st.push(new Pair(i, num));
    		}
    		else {
    			while(!st.isEmpty() && st.peek().num >= num) st.pop();
    			if(st.isEmpty()) sb.append("0 ");
    			else sb.append(st.peek().idx + " ");
    			st.push(new Pair(i, num));
    		}
    	}
    	
    	System.out.println(sb.toString());
	}
}
class Pair {
	int idx, num;
	Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}