import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int w = 0, apple = 0;
		for(int i = 0; i < N; i++) {
			char T = sc.next().charAt(0);
			
			int W = sc.nextInt();
			int H = sc.nextInt();
			int L = sc.nextInt();
			
			if(T == 'A') {
				int res = (W / 12) * (H / 12) * (L / 12);
				apple += res * 4000;
				w += res * 500;
				w += 1000;
			}
			else {
				w += 120 * 50;
			}
		}
		
		System.out.println(w);
		System.out.println(apple);
	}
}