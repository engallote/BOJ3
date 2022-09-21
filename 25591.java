import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	int a = 100 - N, b = 100 - M;
    	int c = 100 - (a + b), d = a * b;
    	int q = d / 100, r = d % 100;
    	
    	System.out.println(a + " " + b + " " + c + " " + d + " " + q + " " + r);
    	
    	if(d >= 100) {
    		c += q;
    		d = r;
    	}
    	System.out.println(c + " " + d);
	}
}