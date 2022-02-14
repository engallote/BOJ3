import java.util.*;

public class Main {
	static int[][] arr;
	static int res;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(--T >= 0) {
        	arr = new int[3][2];
        	
        	for(int i = 0; i < 3; i++) {
        		arr[i][0] = sc.nextInt();
        		arr[i][1] = sc.nextInt();
        	}
        	
        	res = Integer.MAX_VALUE;
        	
        	//�Ϸķ� �� ������ ��
        	ArrayList<Integer> path = new ArrayList<>();
        	solve(0, 0, path);
        	solve(1, 0, path);
        	solve(2, 0, path);
        	solve(3, 0, path);
        	
        	System.out.println(res);
        }
    }
	private static void solve(int what, int idx, ArrayList<Integer> path) {
		if(idx == 3) {
			int sum = 0, max = 0;
			if(what == 0) {
				for(int i = 0; i < 3; i++) {
					sum += arr[i][path.get(i)];
					if(path.get(i) == 0) max = Math.max(max, arr[i][1]);
					else max = Math.max(max, arr[i][0]);
				}
			}
			else if(what == 1) {//path�� ����ִ� ���� ����, ���ʿ� 0, 1 �����ʿ� 2
				//sum�� ���� ����, max�� ���� ����
				sum = Math.max(arr[0][path.get(0)], arr[1][path.get(1)]) + arr[2][path.get(2)];
				max = Math.max(arr[0][path.get(0) == 0 ? 1 : 0] + arr[1][path.get(1) == 0 ? 1 : 0], arr[2][path.get(2) == 0 ? 1 : 0]);
			}
			else if(what == 2) {//path�� ����ִ� ���� ����, ���ʿ� 0, 2 �����ʿ� 1
				sum = Math.max(arr[0][path.get(0)], arr[2][path.get(2)]) + arr[1][path.get(1)];
				max = Math.max(arr[0][path.get(0) == 0 ? 1 : 0] + arr[2][path.get(2) == 0 ? 1 : 0], arr[1][path.get(1) == 0 ? 1 : 0]);
			}
			else {//path�� ����ִ� ���� ����, ���ʿ� 1, 2 �����ʿ� 0
				sum = Math.max(arr[1][path.get(1)], arr[2][path.get(2)]) + arr[0][path.get(0)];
				max = Math.max(arr[1][path.get(1) == 0 ? 1 : 0] + arr[2][path.get(2) == 0 ? 1 : 0], arr[0][path.get(0) == 0 ? 1 : 0]);
			}
			
			res = Math.min(res, sum * max);
			
			return;
		}
		
		path.add(0);
		solve(what, idx + 1, path);
		path.remove(path.size() - 1);
		
		path.add(1);
		solve(what, idx + 1, path);
		path.remove(path.size() - 1);
	}
}