import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	
    	int who = 0;
    	while(A < 5 && B < 5) {
    		if(who == 0) B += A;
    		else A += B;
    		who = 1 - who;
    	}
    	
    	if(A > B) System.out.println("yj");
    	else System.out.println("yt");
	}
}