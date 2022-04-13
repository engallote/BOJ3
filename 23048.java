import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	int N = sc.nextInt();
    	int[] chk = new int[N + 1];
    	int[] arr = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) chk[i] = i;
    	for(int i = 2; i <= N; i++) {
    		if(chk[i] != i) continue;
    		for(int j = i + i; j <= N; j+=i) chk[j] = i;
    	}
    	
    	int idx = 1;
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i <= N; i++) {
    		if(chk[i] == i) {
    			arr[i] = idx;
    			sb.append(idx + " ");
    			++idx;
    		}
    		else {
    			sb.append(arr[chk[i]] + " ");
    		}
    	}
    	
    	System.out.println(idx - 1);
    	System.out.println(sb.toString());
	}
}