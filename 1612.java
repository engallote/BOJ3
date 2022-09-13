import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	if(N % 2 == 0 || N % 5 == 0) {
    		System.out.println(-1);
    		return;
    	}
    	
    	int res = 0;
    	for(int i = 1;;) {
    		res += 1;
    		if(i % N == 0) break;
    		
    		i = (i % N) * 10 + 1;
    	}
    	
    	System.out.println(res);
	}
}