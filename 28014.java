import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int pre = 0, res = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(--N >= 0) {
			int num = Integer.parseInt(st.nextToken());
			if(pre <= num) ++res;
			pre = num;
		}
		
		System.out.println(res);
	}
}