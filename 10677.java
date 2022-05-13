import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<Pair> aly = new ArrayList<>();
		StringTokenizer st;
		while(--K >= 0) {
			st = new StringTokenizer(br.readLine());
			long num1 = Long.parseLong(st.nextToken());
			long num2 = Long.parseLong(st.nextToken());
			
			aly.clear();
			
			long a = 0, b = 0, c = 0, res = 0;
			for(int i = 10; i <= 15000; i++) {
				a = num1;
				b = i;
				c = 1;
				res = 0;
				
				while(a > 0) {
					res += (a % 10) * c;
					a /= 10;
					c *= b;
				}
				
				aly.add(new Pair(res, i, 1));
				
				a = num2;
				b = i;
				c = 1;
				res = 0;
				
				while(a > 0) {
					res += (a % 10) * c;
					a /= 10;
					c *= b;
				}
				
				aly.add(new Pair(res, i, 2));
			}
			
			Collections.sort(aly);
			
			for(int i = 0; i < aly.size() - 1; i++) {
				if(aly.get(i).num == aly.get(i + 1).num) {
					int x = 0, y = 0;
					if(aly.get(i).w == 1) {
						x = aly.get(i).idx;
						y = aly.get(i + 1).idx;
					}
					else {
						x = aly.get(i + 1).idx;
						y = aly.get(i).idx;
					}
					
					bw.write(x + " " + y + "\n");
					break;
				}
			}
		}
		bw.flush();
	}
}
class Pair implements Comparable<Pair> {
	long num;
	int idx, w;
	Pair(long num, int idx, int w) {
		this.num = num;
		this.idx = idx;
		this.w = w;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return -1;
		else if(o.num == this.num) return Integer.compare(this.idx, o.idx);
		else return 1;
	}
}