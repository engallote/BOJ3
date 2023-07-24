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
		
		int idx = 0;//�մ� ��
		int t = 0;//��� ��
		for(int i = 0; i <= 1000000; i++) {
			if(time[i] == 1) {//����
				if(coffee[i] == 0) {
					System.out.println("fail");
					return;
				}
			}
			else {
				if(arr[idx] - M + 1 <= i + 1) {//�մ��� �� ������ ��� ����� Ŀ�� Ÿ�� ���� ����
					if(t == 0) t += 1;//��� ������ ��� �����
					else {//��� ������ Ŀ�� Ÿ��
						coffee[arr[idx]] = 1;
						idx += 1;
						t -= 1;
					}
				}
				else t += 1;//�� �� ������ ��⳪ ������
			}
			
			if(idx == N) break;
		}
		
		System.out.println("success");
	}
}