import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.next().split(":");
		int sh = Integer.parseInt(str[0]), sm = Integer.parseInt(str[1]);
		
		str = sc.next().split(":");
		int eh = Integer.parseInt(str[0]), em = Integer.parseInt(str[1]);
		
		int N = sc.nextInt();
		int T = sc.nextInt();
		
		int ch = sh, cm = sm, day = 0;
		
		while(N >= 0) {
			cm += T;
			if(cm >= 60) {
				cm = cm - 60;
				ch += 1;
			}
			
			if((ch == eh && cm >= em) || ch > eh) {
				day += 1;
				ch = sh;
				cm = sm;
			}
			else N -= 1;
		}
		
		System.out.println(day);
		System.out.println((ch > 9 ? ch : "0" + ch) + ":" + (cm > 9 ? cm : "0" + cm));
	}
}