package BOJ_11726_2xn타일링;

import java.util.Scanner;

public class Main_BOJ_11726_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] f = new int[n+1];
		
		if(n>=1) f[1] = 1; 
		if(n>=2) f[2] = 2;
		
		for(int i = 0; i <= n; i++) {
			if(i >= 3) {
				f[i] = (f[i-1] + f[i-2]) % 10007;
			}
		}
		System.out.println(f[n]);
	}
}
