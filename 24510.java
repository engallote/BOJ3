import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0, sum = 0, idx;
		char[] f = {'f', 'o', 'r'};
		char[] w = {'w', 'h', 'i', 'l', 'e'};
		
		while(--N >= 0) {
			sum = 0;
			char[] ch = sc.next().toCharArray();
			
			idx = 0;
			for(char c : ch) {
				if(c == f[idx]) ++idx;
				else {
					idx = 0;
					if(c == f[idx]) ++idx;
				}
				
				if(idx == 3) {
					idx = 0;
					++sum;
				}
			}
			
			idx = 0;
			for(char c : ch) {
				if(c == w[idx]) ++idx;
				else {
					idx = 0;
					if(c == w[idx]) ++idx;
				}
				
				if(idx == 5) {
					idx = 0;
					++sum;
				}
			}
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}