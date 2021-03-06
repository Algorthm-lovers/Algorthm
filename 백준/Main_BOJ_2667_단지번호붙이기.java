package BOJ_2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2667_단지번호붙이기 {
	static int N, num;
	static int[] dong;
	static char[][] apt;
	static boolean[][] isSel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dong = new int[N*N];	//동의 수는 N^2를 넘지 않는다
		apt = new char[N][N];
		isSel = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			apt[i] = br.readLine().toCharArray();
		}
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(isSel[r][c] || apt[r][c] == '0') continue;
				num++;
				dfs(r, c);
			}
		}
		System.out.println(num);
		dong = Arrays.copyOf(dong, num+1);
		Arrays.sort(dong);
		for(int i = 1; i <= num; i++) {
			System.out.println(dong[i]);
		}
	}
	static int[] dr = {0, -1, 1, 0, 0};	// 한 동에 아파트가 하나일 수도 있으므로, 사방탐색에 자기 자신도 포함시켜야함
	static int[] dc = {0, 0, 0, -1, 1};
	static void dfs(int r, int c) {
		for(int i = 0; i < 5; i++) {
			int nr = r + dr[i]; int nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || apt[nr][nc]=='0' || isSel[nr][nc]) continue;
			isSel[nr][nc] = true;
			dong[num]++;
			dfs(nr, nc);
		}
	}
}
