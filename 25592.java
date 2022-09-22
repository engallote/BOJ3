import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int who = 0, num = 0, res = 0;
    	
    	for(int i = 1;; i++) {
    		if(num + i > N) {
    			if(who == 0) res = (num + i) - N;
    			break;
    		}
    		
    		num += i;
    		who = 1 - who;
    	}
    	
    	System.out.println(res);
	}
}