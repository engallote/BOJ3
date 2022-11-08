import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	while(--T >= 0) {
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		int[] in = new int[N], out = new int[M];
    		
    		for(int i = 0; i < N; i++) in[i] = sc.nextInt();
    		for(int i = 0; i < M; i++) out[i] = sc.nextInt();
    		char[] ch = sc.next().toCharArray();
    		
    		Arrays.sort(in);
    		Arrays.sort(out);
    		
    		int cnt = 0, money = 0, inIdx = N - 1, outIdx = 0;
    		for(char c : ch) {
    			if(c == '+') {
    				money += in[inIdx];
    				--inIdx;
    			}
    			else {
    				if(money < out[outIdx]) {
    					++cnt;
    					continue;
    				}
    				money -= out[outIdx];
    				++outIdx;
    			}
    		}
    		
    		System.out.println(cnt);
    	}
	}
}