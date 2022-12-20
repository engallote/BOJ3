import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	for(int i = 0; i < N; i++) {
    		int M = sc.nextInt();
    		long[][] arr = new long[M][3];
    		long res = 0;
    		
    		for(int j = 0; j < M; j++) {
    			arr[j][0] = sc.nextLong();
    			arr[j][1] = sc.nextLong();
    			arr[j][2] = sc.nextLong();
    		}
    		
    		long k = sc.nextLong();
    		long d = sc.nextLong();
    		long a = sc.nextLong();
    		
    		for(int j = 0; j < M; j++) {
    			long sum = k * arr[j][0] - d * arr[j][1] + a * arr[j][2];
    			if(sum > 0) res += sum;
    		}
    		
    		System.out.println(res);
    	}
	}
}