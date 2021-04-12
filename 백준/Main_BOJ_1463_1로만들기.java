package BOJ_1463_1로만들기;
// DP(동적프로그래밍)
import java.util.Arrays;
import java.util.Scanner;

public class Main_BOJ_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] f = new int[N + 1];	// 최적해 함수 f

		Arrays.fill(f, Integer.MAX_VALUE); // 최소가 되는 최적해를 구해야하므로, 최적해 배열을 최댓값으로 초기화
		f[1] = 0;
		for (int i = 1; i <= N; i++) {
			if (i > 1) {
				f[i] = Math.min(f[i], f[i - 1] + 1);
			}
			if (i % 3 == 0) {
				f[i] = Math.min(f[i], f[i / 3] + 1);
			}
			if (i % 2 == 0) {
				f[i] = Math.min(f[i], f[i / 2] + 1);
			}
		}
		System.out.println(f[N]);

	}
}
