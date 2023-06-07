import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr = new int[1000000];
		
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken().replace("-", ""));
			int e = Integer.parseInt(st.nextToken().replace("-", ""));
			
			arr[s] += 1;
			arr[e + 1] += -1;
		}
		
		int my = 0, mm = 0, cnt = 0, sum = 0;
		for(int i = 200001; i <= 999912; i++) {
			sum += arr[i];
			
			if(sum > cnt) {
				cnt = sum;
				my = i / 100;
				mm = i % 100;
			}
		}
		
		if(mm < 10) System.out.println(my + "-0" + mm);
		else System.out.println(my + "-" + mm);
	}
}