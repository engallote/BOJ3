import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	boolean[] chk = new boolean[1001];
    	int[] arr = new int[1001];
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	int C = sc.nextInt();
    	int D = sc.nextInt();
    	
    	for(int i = 2; i <= 1000; i++) {
    		if(chk[i]) continue;
    		for(int j = i + i; j <= 1000; j+=i) chk[j] = true;
    	}
    	
    	HashMap<Integer, Integer> hs = new HashMap<>();
    	int a = 0, b = 0, same = 0;
    	for(int i = A; i <= B; i++) {
    		if(chk[i]) continue;
    		a += 1;
    		arr[i] += 1;
    		if(arr[i] == 2) ++same;
    	}
    	
    	for(int i = C; i <= D; i++) {
    		if(chk[i]) continue;
    		b += 1;
    		arr[i] += 1;
    		if(arr[i] == 2) ++same;
    	}
    	
    	a -= same;
    	b -= same;
    	
    	int who = 0;
    	while(true) {
    		if(same > 0) same -= 1;
    		else if(who == 0) {
    			if(a == 0) {
    				System.out.println("yj");
    				break;
    			}
    			a -= 1;
    		}
    		else {
    			if(b == 0) {
    				System.out.println("yt");
    				break;
    			}
    			b -= 1;
    		}
    		who = 1 - who;
    	}
	}
}