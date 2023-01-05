import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	HashMap<String, Integer> hm = new HashMap<>();
    	ArrayList<Integer>[] aly = new ArrayList[N];
    	
    	int idx = 0, aIdx = 0, bIdx = 0;
    	for(int i = 0; i < N; i++) aly[i] = new ArrayList<>();
    	for(int i = 0; i < N - 1; i++) {
    		String a = sc.next();
    		String b = sc.next();
    		
    		if(hm.containsKey(a)) aIdx = hm.get(a);
    		else {
    			aIdx = idx;
    			hm.put(a, idx++);
    		}
    		if(hm.containsKey(b)) bIdx = hm.get(b);
    		else {
    			bIdx = idx;
    			hm.put(b, idx++);
    		}
    		
    		aly[aIdx].add(bIdx);
    	}
    	
    	String a = sc.next();
    	String b = sc.next();
    	
    	aIdx = hm.get(a);
    	bIdx = hm.get(b);
    	
    	int res = Math.max(solve(aIdx, bIdx, aly, N), solve(bIdx, aIdx, aly, N));
    	System.out.println(res);
	}

	private static int solve(int s, int e, ArrayList<Integer>[] aly, int n) {
		int ret = 0;
		
		for(int next : aly[s]) {
			if(next == e) return 1;
			ret = Math.max(ret, solve(next, e, aly, n));
		}
		
		return ret;
	}
}