import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	Arrays.sort(arr);
    	
    	int pre = arr[N - 1], res = 0, idx = N - 1;
    	boolean flag = true;
    	while(flag) {
    		flag = false;
    		while(idx > 0) {
    			if(arr[idx] == 10000000) idx -= 1;
    			else {
    				pre = arr[idx];
    				idx -= 1;
    				break;
    			}
    		}
    		for(int i = N - 1; i >= 0; i--)
        		if(pre > arr[i]) {
        			pre = arr[i];
        			arr[i] = 10000000;
        			flag = true;
        		}
    	}
    	
    	for(int i = 0; i < N; i++) if(arr[i] != 10000000) ++res;
    	
    	System.out.println(res);
	}
}