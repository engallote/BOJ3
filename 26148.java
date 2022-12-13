import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int idx = sc.nextInt() - 1, month = 1, day = 1;
    	int[] week = new int[78];
    	int res = 0;
    	
    	while(true) {
    		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
    			for(int i = 1; i <= 31; i++) {
    				week[idx] += 1;
    				if(week[idx] >= 5) ++res;
    				idx += 1;
    				idx %= 7;
    			}
    			month += 1;
    			if(month > 12) break;
    		}
    		else if(month == 2) {
    			if((N % 4 == 0 && N % 100 != 0) || N % 400 == 0) {//À±³â
    				for(int i = 1; i <= 29; i++) {
        				week[idx] += 1;
        				if(week[idx] >= 5) ++res;
        				idx += 1;
        				idx %= 7;
        			}
        			month += 1;
    			}
    			else {
    				for(int i = 1; i <= 28; i++) {
        				week[idx] += 1;
        				if(week[idx] >= 5) ++res;
        				idx += 1;
        				idx %= 7;
        			}
        			month += 1;
    			}
    		}
    		else {
    			for(int i = 1; i <= 30; i++) {
    				week[idx] += 1;
    				if(week[idx] >= 5) ++res;
    				idx += 1;
    				idx %= 7;
    			}
    			month += 1;
    		}
    		
    		Arrays.fill(week, 0);
    	}
    	
    	System.out.println(res);
	}
}