package BOJ_8979_올림픽;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_8979_올림픽 {
	static int N, K;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			arr[k][0] = Integer.parseInt(st.nextToken());
			arr[k][1] = Integer.parseInt(st.nextToken());
			arr[k][2] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(arr[K][0]<arr[i][0]) {
				cnt++;
				continue;
			}
			if(arr[K][0]==arr[i][0]) {
				if(arr[K][1]<arr[i][1]) {
					cnt++;
					continue;
				}
				if(arr[K][1]==arr[i][1]) {
					if(arr[K][2]<arr[i][2]) {
						cnt++;
						continue;
					}
				}
			}
		}
		System.out.println(cnt+1);
	}
}
