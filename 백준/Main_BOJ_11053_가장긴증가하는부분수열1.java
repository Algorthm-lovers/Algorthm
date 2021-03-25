package BOJ_11053_가장긴증가하는부분수열1;
// DP
// O(n^2)
// 11916KB, 100ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11053_가장긴증가하는부분수열1 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] D = new int[N];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			if(i==0) D[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i]>arr[j]) {
					D[i] = Math.max(D[i], D[j]+1);
				}
			}
			if(D[i]==0) D[i] = 1;
			if(D[i] > max) max = D[i];
		}
		
		System.out.println(max);
		
	}
}
