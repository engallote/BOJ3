import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int time = 1, go = 1;		
		while(--N >= 0) {
			String w = sc.next();
			int num = sc.nextInt();
			
			if(w.equals("WATCH")) {
				if(num == time) System.out.println(time + " YES");
				else System.out.println(time + " NO");
			}
			else if(w.equals("CLOCK")) {
				if(num == time) System.out.println(time + " YES");
				else System.out.println(time + " NO");
			}
			else {
				if(num == time) System.out.println(time + " NO");//°úºÎÇÏ
				else {
					System.out.println(time + " NO");
					go *= -1;
				}
			}
			
			time += go;
			if(time > 12) time = 1;
			else if(time < 1) time = 12;
		}
	}
}