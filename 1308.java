import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		int yearEnd = sc.nextInt();
		int monthEnd = sc.nextInt();
		int dayEnd = sc.nextInt();
		
		if(year + 1000 < yearEnd || (year + 1000 == yearEnd && month <= monthEnd && day <= dayEnd)) {
			System.out.println("gg");
			return;
		}
		
		if(year == yearEnd && month == monthEnd && day == dayEnd) {
			System.out.println("D-0");
			return;
		}
		
		int res = 0;
		while(true) {
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(day == 31) {
					day = 0;
					month += 1;
					if(month == 13) {
						month = 1;
						year += 1;
					}
				}
			}
			else if(month == 2) {
				if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
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
			++res;
			if(year == yearEnd && month == monthEnd && day == dayEnd) break;
		}
		
		System.out.println("D-" + res);
	}
}