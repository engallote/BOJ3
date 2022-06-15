import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			int y = sc.nextInt();
			int m = sc.nextInt();
			int d = m;
			int num = m;
			
			while(--num >= 0) {
				d -= 1;
				if(d == 0) {
					m -= 1;
					if(m == 0) {
						m = 12;
						y -= 1;
					}
					
					if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) d = 31;
					else if(m == 2) {
						if(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) d = 29;
						else d = 28;
					}
					else d = 30;
				}
			}
			
			System.out.println(y + " " + m + " " + d);
		}
	}
}