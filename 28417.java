import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int r = 0, t1 = 0, t2 = 0, res = 0;
		for(int i = 0; i < N; i++) {
			r = t1 = t2 = 0;
			for(int j = 0; j < 7; j++) {
				int num = sc.nextInt();
				if(j < 2) {//·±
					r = Math.max(r, num);
				}
				else {//Æ®¸¯
					if(t1 < num) {
						t2 = t1;
						t1 = num;
					}
					else if(t2 < num) {
						t2 = num;
					}
				}
			}
			
			if(r + t1 + t2 > res) res = r + t1 + t2;
		}
		
		System.out.println(res);
	}
}