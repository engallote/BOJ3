import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		BigInteger bg1, bg2;
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {//비교하면서 위치 수정
			for(int j = i + 1; j < N; j++) {
				char[] a = Integer.toString(arr[i]).toCharArray();//현재 숫자
				char[] b = Integer.toString(arr[j]).toCharArray();//다음 숫자
				
				bg1 = new BigInteger(new String(a) + new String(b));
				bg2 = new BigInteger(new String(b) + new String(a));
				
				if(bg1.compareTo(bg2) <= 0) continue;
				
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = N - 1; i >= 0; i--)
			sb.append(arr[i]);
		
		if(sb.toString().charAt(0) == '0') System.out.println(0);
		else System.out.println(sb.toString());
	}
}