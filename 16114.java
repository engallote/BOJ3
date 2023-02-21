import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	if(M == 0) {
    		if(N > 0) System.out.println("INFINITE");
    		else System.out.println(0);
    	}
    	else if(M == 1) {// 4 -> -4, -1 -> 1
    		if(N >= 0) System.out.println(0);
    		else System.out.println("INFINITE");
    	}
    	else if(M % 2 != 0) System.out.println("ERROR");
    	else if(N <= 0) System.out.println(0);
    	else {
    		int res = 0;
    		while(N > 0) {
        		N -= M / 2;
        		if(N <= 0) break;
        		res += 1;
        	}
    		
    		System.out.println(res);
    	}
	}
}