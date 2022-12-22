import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	sc.nextLine();
    	
    	for(int i = 0; i < N; i++) {
    		String[] str = sc.nextLine().split(" ");
    		int[] left = new int[str.length], right = new int[str.length];
    		int res = 0;
    		
    		left[0] = Integer.parseInt(str[0]);
    		right[str.length - 1] = Integer.parseInt(str[str.length - 1]);
    		for(int j = 1; j < str.length; j++) left[j] = Math.max(left[j - 1], Integer.parseInt(str[j]));
    		for(int j = str.length - 2; j >= 0; j--) right[j] = Math.max(right[j + 1], Integer.parseInt(str[j]));
    		
    		for(int j = 1; j < str.length - 1; j++) {
    			if(Integer.parseInt(str[j]) < Math.min(left[j], right[j])) 
    				res += Math.min(left[j], right[j]) - Integer.parseInt(str[j]);
    		}
    		
    		System.out.println(res);
    	}
	}
}