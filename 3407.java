import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static char[] ch;
	static boolean[] chk = new boolean[50010];
	static String[] c = {
			"h", "b", "c", "n", "o", "f", "p", "s", "k", "v", "y", "i", "w", "u",
			"ba", "ca" , "ga", "la", "na", "pa", "ra", "ta", "db", "nb", "pb", "rb", "sb", "tb", "yb", "ac",
			"sc", "tc", "cd", "gd", "md", "nd", "pd", "be", "ce", "fe", "ge", "he", "ne", "re", "se", "te",
			"xe", "cf", "hf", "rf", "ag", "hg", "mg", "rg", "sg", "bh", "rh", "th", "bi", "li", "ni", "si",
			"ti", "bk", "al", "cl", "fl", "tl", "am", "cm", "fm", "pm", "sm", "tm", "cn", "in", "mn", "rn",
			"sn", "zn", "co", "ho", "mo", "no", "po", "np", "ar", "br", "cr", "er", "fr", "ir", "kr", "lr",
			"pr", "sr", "zr", "as", "cs", "ds", "es", "hs", "os", "at", "mt", "pt", "au", "cu", "eu", "lu",
			"pu", "ru", "lv", "dy"};
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			ch = br.readLine().trim().toLowerCase().toCharArray();
			Arrays.fill(chk, false);
			
			if(bfs()) bw.write("YES");
			else bw.write("NO");
			bw.newLine();
		}
		bw.flush();
	}

	private static boolean bfs() {
		boolean flag = false;
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		chk[0] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(x >= ch.length) {
				flag = true;
				break;
			}
			String str1 = "", str2 = "";
			str1 = ch[x] + "";
			if(x + 1 < ch.length) str2 = (ch[x] + "") + (ch[x + 1] + "");
			
			for(int i = 0; i < c.length; i++) {
				if(str1.equals(c[i]) && !chk[x + 1]) {
					chk[x + 1] = true;
					q.offer(x + 1);
				}
				if(str2.equals(c[i]) && !chk[x + 2]) {
					chk[x + 2] = true;
					q.offer(x + 2);
				}
			}
		}
		
		return flag;
	}
}