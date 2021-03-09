package BOJ_7576_토마토;
// 시간초과
// bfs 사용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토v1 {
	static int M, N;
	static int[][] farm;
	static boolean[][] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		farm = new int[N][M];
		farmCopy = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());
				farmCopy[i][j] = farm[i][j];
			}
		}
		// true가 return되면 day값을, false가 return되면 -1을 찍어주도록 한다
		System.out.println(bfs()?day:-1);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] farmCopy;
	static int day;
	static int check;
	
	static boolean bfs() {	
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(farmCopy[r][c]==0) {
					cnt++;
					break;
				}
			}
		}
		if(cnt==0) return true;	// 모든 토마토가 익었으면 true 반환
		
		if(day!=0 && check==0) return false; // 이전 단계에서 새로 익은 토마토가 없고, 모든 토마토가 익은 것이 아니라면 false 반환
		check = 0;	// 체크 후 check값 0으로 초기화
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				farm[r][c] = farmCopy[r][c];
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(farm[r][c] == 1 && !isVisited[r][c]) { // 해당 위치의 토마토가 익었고, 주변 토마토를 익힌 적이 없으면 사방 토마토도 익힌다
					for(int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if(nr >= N || nr < 0 || nc >= M || nc < 0 || farm[nr][nc]!=0) continue;
						farmCopy[nr][nc] = 1;
						check++;
						// 시간초과 뜨면 이 단계에서, 새롭게 추가된 토마토의 좌표를 따로 저장하고 따로 저장된 위치에 대해서만 연산 수행한다
					}
					isVisited[r][c] = true;	// 이미 한 번 주변 토마토를 익혔으면 표시해둔다
				}
			}
		}
		day++;
		
		return bfs();
	}
}
