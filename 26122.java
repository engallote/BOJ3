import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	int s = 0, n = 0, tmp = 0, res = 0;
    	for(int i = 0; i < N; i++) {
    		if(ch[i] == 'S') {
    			n = 0;
    			++s;
    			
    			for(int j = i + 1; j < Math.min(i + 1 + s, N); j++) {
    				if(ch[j] == 'N') tmp += 1;
    				else break;
    			}
    			
    			if(s >= tmp) res = Math.max(res, Math.min(s, tmp) * 2);
    			tmp = 0;
    		}
    		else {
    			s = 0;
    			++n;
    			
    			for(int j = i + 1; j < Math.min(i + 1 + n, N); j++) {
    				if(ch[j] == 'S') tmp += 1;
    				else break;
    			}
    			
    			if(n >= tmp) res = Math.max(res, Math.min(n, tmp) * 2);
    			tmp = 0;
    		}
    		
    		if(res == N) break;
    	}
    	
    	System.out.println(res);
	}
}