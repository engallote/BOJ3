import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	int res = 0, min = 1000000009;
    	for(int i = 0; i < N; i++) {
    		int num = sc.nextInt();
    		res = Math.max(res, num - min);
    		min = Math.min(min, num);
    	}
    	
    	System.out.println(res);
	}
}