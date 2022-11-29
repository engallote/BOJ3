import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] a = sc.next().toCharArray();
    	char[] b = sc.next().toCharArray();
    	int len = a.length;
    	
    	int[] alp = new int[26];
    	
    	for(int i = 0; i < len; i++) alp[a[i] - 'A'] += 1;
    	for(int i = 0; i < len; i++) alp[b[i] - 'A'] -= 1;
    	
    	for(int i = 0; i < 26; i++)
    		if(alp[i] != 0) {
    			System.out.println(-1);
    			return;
    		}
    	
    	int aIdx = len - 1, bIdx = len - 1, res = 0;
    	while(aIdx >= 0) {
    		if(a[aIdx] == b[bIdx]) {
    			--aIdx;
    			--bIdx;
    		}
    		else {
    			--aIdx;
    			++res;
    		}
    	}
    	
    	System.out.println(res);
	}
}