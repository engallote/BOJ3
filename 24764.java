import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		char[] word = {'.', '.', '.', '.', '.'};
		boolean[][] chk = new boolean[5][26];
		int[] alp = new int[26];
		
		for(int i = 0; i < N; i++) {
			char[] ch = sc.next().toCharArray();
			char[] k = sc.next().toCharArray();
			
			for(int j = 0; j < 5; j++) {
				if(k[j] == 'G') word[j] = ch[j];
				else if(k[j] == 'Y') {//�ܾ ����ִ� ���ĺ�
					chk[j][ch[j] - 'A'] = true;
					alp[ch[j] - 'A'] = 1;
				}
				else alp[ch[j] - 'A'] = -1;//�ܾ ������� ���� ���ĺ�
			}
		}
		
		boolean[] arr = new boolean[26];
		for(int i = 0; i < W; i++) {
			char[] ch = sc.next().toCharArray();
			boolean flag = true;
			Arrays.fill(arr, false);
			
			for(int j = 0; j < 5; j++) {
				arr[ch[j] - 'A'] = true;
				
				if(word[j] != '.') {//�ش� ��ġ�� ���ĺ��� Ư���Ǿ� �ִٸ�
					if(word[j] == ch[j]) continue;
					else {
						flag = false;
						break;
					}
				}				
				if(alp[ch[j] - 'A'] == -1) {//Gray�� �ش��ϴ� ���ĺ��� ������ �� �ȴ�
					flag = false;
					break;
				}
				if(chk[j][ch[j] - 'A']) {//�� �ڸ��� �ش� ���ĺ��� ������ �� �ȴ�
					flag = false;
					break;
				}
			}
			
			if(!flag) continue;
			
			for(int j = 0; j < 26; j++)
				if(alp[j] > 0 && !arr[j]) {
					flag = false;
					break;
				}
			
			if(flag) System.out.println(new String(ch));
		}
	}
}