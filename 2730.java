import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	while(--N >= 0) {
    		String[] date1 = sc.next().split("/");
    		String[] date2 = sc.next().split("/");
    		
    		int m1 = Integer.parseInt(date1[0]), d1 = Integer.parseInt(date1[1]), y = Integer.parseInt(date1[2]);
    		int m2 = Integer.parseInt(date2[0]), d2 = Integer.parseInt(date2[1]);
    		
    		if(m1 == m2 && d1 == d2) {
    			System.out.println("SAME DAY");
    		}
    		else {
    			int day = d1, month = m1, year = y, i;
    			boolean flag = false;
    			
    			//prior
    			for(i = 1; i <= 7; i++) {
    				day += 1;
    				
    				if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
    					if(day == 32) {
    						day = 1;
    						month += 1;
    						if(month > 12) {
    							month = 1;
    							year += 1;
    						}
    					}
    				}
    				else if(month == 2) {
    					if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {//À±³â
    						if(day == 30) {
    							day = 1;
    							month += 1;
    						}
    					}
    					else {
    						if(day == 29) {
    							day = 1;
    							month += 1;
    						}
    					}
    				}
    				else {
    					if(day == 31) {
    						day = 1;
    						month += 1;
    					}
    				}
    				
    				if(month == m2 && day == d2) {
    					flag = true;
    					break;
    				}
    			}
    			
    			if(flag) {
    				if(i == 1) System.out.println(m2+"/"+d2+"/"+year + " IS 1 DAY AFTER");
    				else System.out.println(m2+"/"+d2+"/"+year + " IS " + i + " DAYS AFTER");
    				continue;
    			}
    			
    			//after
    			day = d1;
    			month = m1;
    			year = y;
    			for(i = 1; i <= 7; i++) {
    				day -= 1;
    				
    				if(day == 0) {
    					month -= 1;
    					if(month == 0) {
    						month = 12;
    						year -= 1;
    					}
    					if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
    						day = 31;
        				}
        				else if(month == 2) {
        					if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {//À±³â
        						day = 29;
        					}
        					else {
        						day = 28;
        					}
        				}
        				else day = 30;
    				}
    				
    				if(month == m2 && day == d2) {
    					flag = true;
    					break;
    				}
    			}
    			
    			if(flag) {
    				if(i == 1) System.out.println(m2+"/"+d2+"/"+year + " IS 1 DAY PRIOR");
    				else System.out.println(m2+"/"+d2+"/"+year + " IS " + i + " DAYS PRIOR");
    				continue;
    			}
    			
    			System.out.println("OUT OF RANGE");
    		}
    	}
    	
	}
}