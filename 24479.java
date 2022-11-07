import java.util.*;

public class Main {
	static int N, M, R;
	static int[] chk;
	static ArrayList<Integer>[] aly;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	R = sc.nextInt();
    	chk = new int[N + 1];
    	aly = new ArrayList[N + 1];
    	
    	for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		aly[a].add(b);
    		aly[b].add(a);
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		Collections.sort(aly[i]);
    		Collections.reverse(aly[i]);
    	}
    	
    	Stack<Integer> st = new Stack<>();
    	st.push(R);
    	
    	int cnt = 1;
    	while(!st.isEmpty()) {
    		int x = st.pop();
    		if(chk[x] == 0) chk[x] = cnt++;
    		
    		for(int next : aly[x])
    			if(chk[next] == 0) st.push(next);
    	}
    	
    	for(int i = 1; i <= N; i++) System.out.println(chk[i]);
	}
}