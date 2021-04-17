package BOJ_14890_경사로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14890_경사로 {
	static int N, L, answer, count, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 0. 입력
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 가로줄 기준
		for(int i = 0; i < N; i++) {
			count = 0;
			int height = map[i][0];
			for(int j = 0; j < N; j++) {
				if(height == map[i][j]) count ++;
				else if(height - map[i][j] == -1) { // 높이가 1 높아진 경우
					if(count < L) break;	// 앞의 평지 길이가 L 미만이면 못 가는 길
					else {
						count = 1;			// 앞의 평지 길이가 L 이상이면 count 1으로 초기화, height를 현재 높이로 바꿔주고 계속 가던 길 가기
						height = map[i][j];
					}
				}else if(height - map[i][j] == 1) {	// 높이가 1 낮아진 경우
					height = map[i][j];
					int tempCnt = 1;
					while(tempCnt != L) {
						j++;
						if(j == N || map[i][j] != height) break; // ////////////// 조건 체크하기 j==N? j==N-1?
						tempCnt++;
					}
					if(tempCnt == L){
						count = 0;
					} else break; 
				} else break; // 높이 차이가 1 초과인 경우 갈 수 없는 길
				
				if(j==N-1) answer++;	// 길의 끝에 도달했으면 갈 수 있는 길
			}
		}
		
		
		// 2. 세로줄 기준
		for(int i = 0; i < N; i++) {
			count = 0;
			int height = map[0][i];
			for(int j = 0; j < N; j++) {
				if(height == map[j][i]) count ++;
				else if(height - map[j][i] == -1) { // 높이가 1 높아진 경우
					if(count < L) break;	// 앞의 평지 길이가 L 미만이면 못 가는 길
					else {
						count = 1;			// 앞의 평지 길이가 L 이상이면 count 1으로 초기화, height를 현재 높이로 바꿔주고 계속 가던 길 가기
						height = map[j][i];
					}
				}else if(height - map[j][i] == 1) {	// 높이가 1 낮아진 경우
					height = map[j][i];
					int tempCnt = 1;
					while(tempCnt != L) {
						j++;
						if(j == N || map[j][i] != height) break; // ////////////// 조건 체크하기 j==N? j==N-1?
						tempCnt++;
					}
					if(tempCnt == L){
						count = 0;
					} else break; 
				} else break; // 높이 차이가 1 초과인 경우 갈 수 없는 길
				
				if(j==N-1) answer++;	// 길의 끝에 도달했으면 갈 수 있는 길
			}
		}
		
		System.out.println(answer);
		
	}
}
