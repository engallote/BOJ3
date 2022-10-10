import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	int l = 0, r = N - 1, res = 0;
    	while(l < r) {
    		if(ch[l] != ch[r]) ++res;
    		l += 1;
    		r -= 1;
    	}
    	
    	System.out.println(res);
	}
}