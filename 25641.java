import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	
    	int s = 0, t = 0, idx = N;
    	for(int i = N - 1; i >= 0; i--) {
    		if(ch[i] == 's') ++s;
    		else ++t;
    		
    		if(s == t) idx = i;
    	}
    	
    	System.out.println(new String(ch).substring(idx));
	}
}