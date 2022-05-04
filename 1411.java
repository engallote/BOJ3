import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] arr = new char[N][];
		char[] a = new char[26], b = new char[26];
		
		for(int i = 0; i < N; i++) arr[i] = sc.next().toCharArray();
		
		int res = 0;
		boolean flag = false;
		for(int i = 0; i < N - 1; i++)
			for(int j = i + 1; j < N; j++) {
				if(arr[i].length != arr[j].length) continue;		
				Arrays.fill(a, '.');
				Arrays.fill(b, '.');
				
				flag = true;
				for(int k = 0; k < arr[i].length; k++) {
					if(a[arr[i][k] - 'a'] == '.' && b[arr[j][k] - 'a'] == '.') {
						a[arr[i][k] - 'a'] = arr[j][k];
						b[arr[j][k] - 'a'] = arr[i][k];
					}
					else if(a[arr[i][k] - 'a'] != arr[j][k]) {
						flag = false;
						break;
					}
					else if(b[arr[j][k] - 'a'] != arr[i][k]) {
						flag = false;
						break;
					}
				}
				
				if(flag) ++res;
			}
		
		System.out.println(res);
	}
}