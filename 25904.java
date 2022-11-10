import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int X = sc.nextInt();
    	int[] arr = new int[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
    	
    	int idx = 0;
    	while(true) {
    		if(arr[idx] >= X) {
    			++X;
    			++idx;
    			idx %= N;
    			continue;
    		}
    		else {
    			System.out.println(idx + 1);
    			break;
    		}
    	}
	}
}