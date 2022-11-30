import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int res = 0;
    	
    	for(int i = 0; i < N; i++) {
    		String[] str = sc.next().split("-");
    		
    		int num = Integer.parseInt(str[1]);
    		if(num <= 90) ++res;
    	}
    	
    	System.out.println(res);
	}
}