import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		
		for(int i = 0; i < 7; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		boolean AB = false, AC = false, BC = false, ABC = false;
		
		for(int i = 0; i < 5; i++)
			for(int j = i + 1; j < 6; j++)
				for(int k = j + 1; k < 7; k++) {
					
					for(int a = 0; a < 7; a++) {
						if(a == i || a == j || a == k) continue;
						if(!AB && arr[a] == arr[i] + arr[j]) AB = true;
						else if(!AC && arr[a] == arr[i] + arr[k]) AC = true;
						else if(!BC && arr[a] == arr[j] + arr[k]) BC = true;
						else if(arr[a] == arr[i] + arr[j] + arr[k]) ABC = true;
						else break;
					}
					
					if(AB && AC && BC && ABC) {
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
						return;
					}
				}
	}
}