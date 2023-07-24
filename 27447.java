import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int[] coffee = new int[1000001];
		int[] time = new int[1000001];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			time[arr[i]] = 1;
		}
		
		int idx = 0;//손님 수
		int t = 0;//토기 수
		for(int i = 0; i <= 1000000; i++) {
			if(time[i] == 1) {//서빙
				if(coffee[i] == 0) {
					System.out.println("fail");
					return;
				}
			}
			else {
				if(arr[idx] - M + 1 <= i + 1) {//손님이 올 때까지 토기 만들고 커피 타고 서빙 가능
					if(t == 0) t += 1;//토기 없으면 토기 만들기
					else {//토기 있으면 커피 타기
						coffee[arr[idx]] = 1;
						idx += 1;
						t -= 1;
					}
				}
				else t += 1;//할 일 없으면 토기나 만들자
			}
			
			if(idx == N) break;
		}
		
		System.out.println("success");
	}
}