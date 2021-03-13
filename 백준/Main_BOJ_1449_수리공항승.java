package BOJ_1449_수리공항승;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1449_수리공항승 {
	static int N, L, cnt;
	static int[] arr;
	static float cur;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);	// 오름차순으로 정렬
		
		for(int i = 0; i < N; i++) {
			if(arr[i] < cur) continue;
			cur = (float) (arr[i] + (L-0.5));
			cnt++;
		}
		System.out.println(cnt);
	}
}
