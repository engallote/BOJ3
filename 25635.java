import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	long[] arr = new long[N];
    	long sum = 0;
    	for(int i = 0; i < N; i++) {
    		arr[i] = sc.nextLong();
    		sum += arr[i];
    	}
    	Arrays.sort(arr);
    	
    	if(sum % 2 == 0) {
    		if(arr[N - 1] > sum / 2) System.out.println((sum - arr[N - 1]) * 2 + 1);
    		else System.out.println(sum);
    	}
    	else {
    		if(arr[N - 1] > sum / 2 + 1) System.out.println((sum - arr[N - 1]) * 2 + 1);
    		else System.out.println(sum);
    	}
	}
}