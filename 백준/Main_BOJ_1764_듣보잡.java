package BOJ_1764_듣보잡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1764_듣보잡 {
	static int N, M;
	static String[] a, b;
	static Queue<String> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new String[N];
		b = new String[M];
		for(int i = 0; i < N; i++) {
			a[i] = br.readLine();
		}
		for(int i = 0; i < M; i++) {
			b[i] = br.readLine();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		
		StringBuilder sb = new StringBuilder();
		q = new LinkedList<>();
		
		int i = 0, j = 0;
		while(i < N && j < M) {
				if(a[i].compareTo(b[j])<0) {
					i++;
					continue;
				}
				if(a[i].compareTo(b[j])>0) {
					j++;
					continue;
				}
				if(a[i].compareTo(b[j])==0) {
					q.add(a[i]);	// 큐에 담고, b는 다음 인덱스로 넘어간다
					j++;
					continue;
				}
		}
		sb.append(q.size()).append('\n');
		while(!q.isEmpty()) {
			sb.append(q.poll()).append('\n');
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
