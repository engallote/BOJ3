import java.util.*;

public class Main {
	static int C, P;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		P = sc.nextInt();
		arr = new int[C];
		
		for(int i = 0; i < C; i++) arr[i] = sc.nextInt();
		
		int res = 0;
		for(int i = 0; i < C; i++) res += solve(i);
		
		System.out.println(res);
	}
	private static int solve(int idx) {
		int ret = 0;
		if(P == 1) {
			ret += 1;// |
			//ㅡ
			if(idx + 3 < C && arr[idx] == arr[idx + 1] && arr[idx + 1] == arr[idx + 2] && arr[idx + 2] == arr[idx + 3])
				ret += 1;
		}
		else if(P == 2) {
			if(idx + 1 < C && arr[idx] == arr[idx + 1]) ret += 1;
		}
		else if(P == 3) {
			//z 반대
			if(idx + 2 < C && arr[idx] == arr[idx + 1] && arr[idx + 1] + 1 == arr[idx + 2])
				ret += 1;
			//세웠을 때
			if(idx + 1 < C && arr[idx] - 1 == arr[idx + 1]) ret += 1;
		}
		else if(P == 4) {
			//z
			if(idx + 2 < C && arr[idx] - 1 == arr[idx + 1] && arr[idx + 1] == arr[idx + 2])
				ret += 1;
			//세웠을 때
			if(idx + 1 < C && arr[idx] + 1 == arr[idx + 1]) ret += 1;
		}
		else if(P == 5) {
			//ㅗ
			if(idx + 2 < C && arr[idx] == arr[idx + 1] && arr[idx + 1] == arr[idx + 2])
				ret += 1;
			//ㅏ
			if(idx + 1 < C && arr[idx] + 1 == arr[idx + 1]) ret += 1;
			//ㅜ
			if(idx + 2 < C && arr[idx] - 1 == arr[idx + 1] && arr[idx + 1] + 1 == arr[idx + 2])
				ret += 1;
			//ㅓ
			if(idx + 1 < C && arr[idx] - 1 == arr[idx + 1]) ret += 1;
		}
		else if(P == 6) {
			//ㄴ 반대
			if(idx + 2 < C && arr[idx] == arr[idx + 1] && arr[idx + 1] == arr[idx + 2])
				ret += 1;
			//긴 ㄱ
			if(idx + 1 < C && arr[idx] - 2 == arr[idx + 1]) ret += 1;
			//ㄱ 반대
			if(idx + 2 < C && arr[idx] + 1 == arr[idx + 1] && arr[idx + 1] == arr[idx + 2])
				ret += 1;
			//긴 ㄴ 반대
			if(idx + 1 < C && arr[idx] == arr[idx + 1]) ret += 1;
		}
		else {
			//ㄴ
			if(idx + 2 < C && arr[idx] == arr[idx + 1] && arr[idx + 1] == arr[idx + 2])
				ret += 1;
			//긴 ㄴ 반대
			if(idx + 1 < C && arr[idx] == arr[idx + 1]) ret += 1;
			//ㄱ
			if(idx + 2 < C && arr[idx] == arr[idx + 1] && arr[idx + 1] - 1 == arr[idx + 2])
				ret += 1;
			//긴 ㄱ 반대
			if(idx + 1 < C && arr[idx] + 2 == arr[idx + 1]) ret += 1;
		}
		return ret;
	}
}