import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	long X = sc.nextInt();
    	long Y = sc.nextInt();
    	
    	long sub = Y - X;
    	
    	if(X == Y) {
    		System.out.println(0);
    		return;
    	}
    	
    	long sq = 1;
    	while(sq * sq < sub) ++sq;
    	if(sq * sq > sub) --sq;
    	
    	long res = 2 * sq - 1;
    	sub -= sq * sq;
    	
    	while(sub > 0) {
    		sub -= Math.min(sq, sub);
    		++res;
    	}
    	
    	System.out.println(res);
	}
}