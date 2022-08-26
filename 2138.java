import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		char[] res = sc.next().toCharArray();
		char[] tmp = new char[arr.length];
		
		for(int i = 0; i < N; i++) tmp[i] = arr[i];
		
		int cnt = 0, count = Integer.MAX_VALUE;
		for(int i = 1; i < N; i++) {
			if(tmp[i - 1] != res[i - 1]) {
				++cnt;
				tmp[i] = tmp[i] == '0' ? '1' : '0';
				tmp[i - 1] = tmp[i - 1] == '0' ? '1' : '0';
				if(i + 1 < N) tmp[i + 1] = tmp[i + 1] == '0' ? '1' : '0';
			}
		}
		
		boolean flag = true;
		for(int i = 0; i < N; i++)
			if(tmp[i] != res[i]) {
				flag = false;
				break;
			}
		
		if(flag) count = Math.min(cnt, count);
		for(int i = 0; i < N; i++) tmp[i] = arr[i];
		cnt = 1;
		tmp[0] = tmp[0] == '0' ? '1' : '0';
		tmp[1] = tmp[1] == '0' ? '1' : '0';
		
		for(int i = 1; i < N; i++) {
			if(tmp[i - 1] != res[i - 1]) {
				++cnt;
				tmp[i] = tmp[i] == '0' ? '1' : '0';
				tmp[i - 1] = tmp[i - 1] == '0' ? '1' : '0';
				if(i + 1 < arr.length) tmp[i + 1] = tmp[i + 1] == '0' ? '1' : '0';
			}
		}
		
		flag = true;
		for(int i = 0; i < N; i++)
			if(tmp[i] != res[i]) {
				flag = false;
				break;
			}
		
		if(flag) count = Math.min(cnt, count);
		System.out.println(count == Integer.MAX_VALUE ? -1 : count);
	}
}