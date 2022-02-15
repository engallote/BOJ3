import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()) {
			long N = sc.nextLong();
			long num = 0;
			
			for(long i = 1l;; i++) {
				num = (num * 10 + 1) % N;
				if(num == 0) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}