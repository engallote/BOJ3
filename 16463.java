import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	int year = 2019, month = 1, day = 1, day2 = 2, res = 0;
    	while(year <= N) {
    		if(day == 13 && day2 == 5) ++res;
    		
    		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 ||month == 12) {
    			if(day == 31) {
    				day = 0;
    				month += 1;
    			}
    			if(month > 12) {
    				month = 1;
    				year += 1;
    			}
    		}
    		else if(month == 2) {
    			if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
    				if(day == 29) {
    					day = 0;
    					month += 1;
    				}
        		}
        		else {
        			if(day == 28) {
        				day = 0;
        				month += 1;
        			}
        		}
    		}
    		else {
    			if(day == 30) {
    				day = 0;
    				month += 1;
    			}
    		}
    		day += 1;
    		day2 += 1;
    		day2 %= 7;
    	}
    	
    	System.out.println(res);
	}
}