import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String jinho = sc.next();
    	int N = sc.nextInt();
    	
    	int res = 0;
    	for(int i = 0; i < N; i++) {
    		String mbti = sc.next();
    		if(jinho.equals(mbti)) ++res;
    	}
    	
    	System.out.println(res);
	}
}