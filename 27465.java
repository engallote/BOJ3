import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	long N = sc.nextLong();
    	if(N == 1) System.out.println(4);
    	else if(N * 2 <= 1000000000) System.out.println(N * 2);
    	else {
    		while(N <= 1000000000) {
    			for(int i = 2; i * i <= N; i++)
    				if(N % i == 0) {
    					System.out.println(N);
    					return;
    				}
    			N += 1;
    			if(N % 10 == 3 || N % 10 == 9) {
    				N += 1;
    			}
    		}
    	}
	}
}