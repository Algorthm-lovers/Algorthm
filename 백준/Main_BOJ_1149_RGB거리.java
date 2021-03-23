package BOJ_1149_RGB거리;
// DP - 동적 프로그래밍
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] house = new int[N+1][3];
		int[][] f = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());	// R
			house[i][1] = Integer.parseInt(st.nextToken()); // G
			house[i][2] = Integer.parseInt(st.nextToken()); // B
		}
		// 점화식 : 현재 단계에서 색을 골랐을 때의 최적값 = 이전 단계에서의 최적값(2개 존재) + 현재 고른 값
		// N단계에서 R, G, B 세 가지를 골랐을 때의 최적값을 모두 구하고, 그 중 최소값을 출력한다.
		for(int i = 1; i <= N; i++) {
			f[i][0] = house[i][0] + Math.min(f[i-1][1], f[i-1][2]);
			f[i][1] = house[i][1] + Math.min(f[i-1][0], f[i-1][2]);
			f[i][2] = house[i][2] + Math.min(f[i-1][0], f[i-1][1]);
		}
		
		System.out.println(Math.min(f[N][0], Math.min(f[N][1], f[N][2])));
	}
}
