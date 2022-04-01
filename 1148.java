import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[][] dic = new char[200001][];
		int idx = 0;
		while(true) {
			String str = br.readLine().trim();
			
			if(str.equals("-")) break;
			dic[idx] = str.toCharArray();
			idx += 1;
		}
		
		int[] alp = new int[26], tmp = new int[26];
		while(true) {
			char[] ch = br.readLine().trim().toCharArray();
			
			if(ch[0] == '#') break;
			
			Arrays.fill(alp, 0);
			Arrays.fill(tmp, 0);
			
			for(int i = 0; i < ch.length; i++) {
				alp[ch[i] - 'A'] += 1;
				tmp[ch[i] - 'A'] += 1;
			}
			
			boolean flag = false, m = false;
			int max = -1, min = Integer.MAX_VALUE, cnt = 0;
			PriorityQueue<Character> qMax = new PriorityQueue<>(), qMin = new PriorityQueue<>();
			
			for(int i = 0; i < ch.length; i++) {
				char mid = ch[i];//해당 알파벳을 정중앙에
				cnt = 0;
				
				//사전에 들어있는 단어 확인하기
				for(int k = 0; k < idx; k++) {
					flag = true;
					m = false;
					
					for(int j = 0; j < dic[k].length; j++) {
						if(dic[k][j] == mid) m = true;//정중앙 알파벳 들어있음
						if(tmp[dic[k][j] - 'A'] - 1 >= 0) tmp[dic[k][j] - 'A'] -= 1;
						else {//퍼즐판에 없거나 다 쓴 알파벳
							flag = false;
							break;
						}
					}
					
					if(flag && m) ++cnt;
					//확인용 알파벳 숫자 원래 상태로
					for(int j = 0; j < 26; j++) tmp[j] = alp[j];
				}
				
				if(cnt > max) {
					max = cnt;
					qMax.clear();
					qMax.add(mid);
				}
				else if(cnt == max && !qMax.contains(mid)) qMax.add(mid);
				
				if(cnt < min) {
					min = cnt;
					qMin.clear();
					qMin.add(mid);
				}
				else if(cnt == min && !qMin.contains(mid)) qMin.add(mid);
			}
			
			while(!qMin.isEmpty()) bw.write(qMin.poll());
			bw.write(" " + min + " ");
			while(!qMax.isEmpty()) bw.write(qMax.poll());
			bw.write(" " + max + "\n");
		}
		bw.flush();
	}
}