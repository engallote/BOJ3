import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] res = new int[N], arr = new int[N], swap = new int[N];
		
		int num = 0;
		for(int i = 0; i < N; i++) {
			res[i] = sc.nextInt();
			arr[i] = num;
			num = (num + 1) % 3;
		}
		
		for(int i = 0; i < N; i++) swap[i] = sc.nextInt();
		
		int[] tmp = new int[N];
		StringBuilder sb;
		HashSet<String> hs = new HashSet<>();
		boolean flag;
		for(int t = 0;; t++) {
			flag = true;
			for(int k = 0; k < N; k++)
				if(res[k] != arr[k]) {
					flag = false;
					break;
				}
			
			if(flag) {
				System.out.println(t);
				return;
			}
			
			//Ä«µå ¼¯±â
			sb = new StringBuilder();
			for(int i = 0; i < N; i++) tmp[i] = arr[swap[i]];
			for(int i = 0; i < N; i++) {
				arr[i] = tmp[i];
				sb.append(arr[i]);
			}
			
			if(hs.contains(sb.toString())) break;
			hs.add(sb.toString());
		}
		
		System.out.println(-1);
	}
}