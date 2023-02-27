import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long K = sc.nextLong();
		
		if(K < 10) {
			if(N < K) System.out.println(-1);
			else System.out.println(K);
			return;
		}
		
		boolean flag = false;
		long pre = 1l, num = 1l, size = 0l, len = 0l;
		while(len < K) {
			size += 1;
			pre = num;
			num *= 10;
			
			if(len + (num - pre) * size >= K) {
				flag = true;
				break;
			}
			
			len += (num - pre) * size;
		}
		
		if(!flag) {
			System.out.println(-1);
			return;
		}
		
		while(pre <= N) {
			if(len + size >= K) {
				char[] ch = String.valueOf(pre).toCharArray();
				for(char c : ch) {
					len += 1;
					if(len == K) {
						System.out.println(c);
						return;
					}
				}
				
				break;
			}
			len += size;
			pre += 1;
		}
		System.out.println(-1);
	}
}