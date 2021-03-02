package BOJ_10942_팰린드롬;
// 짝수, 홀수개로 나누어서 한 번 진행할 때 마다 테이블에 저장
// 시간초과
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10942_팰린드롬2 {
	static int N, M, S, E;
	static int[] arr, pal, pal2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		pal = new int[N + 1];
		pal2 = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			int ans = 1, cnt = 0;
			int half = (S + E) / 2, diff = E - half, Remainder = (S + E) % 2;
			if (Remainder == 0) { // 홀수개 팰린드롬
				if (pal[half] >= diff) {
				} else {
					while (S + pal[half] <= E - pal[half]) {
						if (arr[S] != arr[E]) {
							ans = 0;
							pal[half] = Math.max(pal[half], cnt);
							break;
						}
						S++;
						E--;
						cnt++;
					}
					if (S >= E) {
						pal[half] = diff;
					}
				}
			} else { // 짝수개 팰린드롬
				if (pal2[half] >= diff) {
				} else {
					while (S + pal2[half] <= E - pal2[half]) {
						if (arr[S] != arr[E]) {
							ans = 0;
							pal2[half] = Math.max(pal[half], cnt);
							break;
						}
						S++;
						E--;
						cnt++;
					}
					if (S >= E) {
						pal2[half] = diff;
					}
				}
			}

			System.out.println(ans);
		}
	}
}
