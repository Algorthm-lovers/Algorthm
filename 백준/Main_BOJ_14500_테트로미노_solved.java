package BOJ_14500_테트로미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14500_테트로미노_solved {
	static int N, M, sum, paper[][], answer;
	static boolean[][] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 세로
		M = Integer.parseInt(st.nextToken());	// 가로
		
		paper = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				isVisited[i][j] = true;
				dfs(i, j, 0);
				isVisited[i][j] = false;	// 여기서 false처리 하지 않으면 i == 0, j == 0 일때 x
											// 반례는 최하단에 적어두었다.
			}
		}
		
		System.out.println(answer);
		
	}
	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	static void dfs(int r, int c, int cnt) {
		/** 한 줄로 만들 수 있는 블럭(정사각형 포함) */
		if(cnt==4) {
			answer = Math.max(answer, sum);
			return;
		}
		int[] dir = new int[4];
		int dirCnt = 0;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			
			dir[d] = paper[nr][nc];	// 범위초과가 아니면 해당 방향으로 갈 수 있음을 표시
			dirCnt++;				// 갈수 있는 방향의 수
			
			if(isVisited[nr][nc]) continue;
			
			isVisited[nr][nc] = true;
			sum += paper[nr][nc];
			dfs(nr, nc, cnt+1);
			isVisited[nr][nc] = false;
			sum -= paper[nr][nc];
		}
		/** 갈 수 있는 방향의 수가 3 이상이면 해당 블록을 중심으로 하는 ㅗ, ㅓ, ㅜ, ㅏ 모양의 블럭을 만들 수 있다. */
		int tempSum = paper[r][c];
		if(dirCnt == 3) {
			for(int i = 0; i < 4; i++) {
				int temp = dir[i];
				if(temp!=0) tempSum += temp;
			}
			answer = Math.max(answer, tempSum);
		}else if(dirCnt == 4) {
			for(int i = 0; i < 4; i++) {
				tempSum += dir[i];
			}
			for(int i = 0; i < 4; i++) {
				tempSum -= dir[i];
				answer = Math.max(answer, tempSum);
				tempSum += dir[i];
			}
		}
	}
}
/**
반례

4 5
9 3 2 1 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
*/