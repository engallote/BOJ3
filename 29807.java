import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] arr = new long[5];
		
		for(int i = 0; i < T; i++) arr[i] = sc.nextLong();
		
		long num1 = 0, num2 = 0, num3 = 0;
		
		if(arr[0] > arr[2]) num1 = Math.abs(arr[0] - arr[2]) * 508l;
		else num1 = Math.abs(arr[0] - arr[2]) * 108l;
		
		if(arr[1] > arr[3]) num2 = Math.abs(arr[1] - arr[3]) * 212l;
		else num2 = Math.abs(arr[1] - arr[3]) * 305l;
		
		if(T == 5) num3 = arr[4] * 707l;
		
		long res = num1 + num2 + num3;
		res *= 4763l;
		
		System.out.println(res);
	}
}