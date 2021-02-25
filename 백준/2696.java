import java.io.*;
import java.util.PriorityQueue;
// 생각한 해결법 : 최대 heap 에서 최대값 구하고 최소 heap에서 최소값 구해서 평균값을 구한다.

public class Main
{
	public static void main(String[] args) {
	    
		BufferedReader bf = new BufferedReader(new inputStreamReader(System.in));
		
		int test_case = 0; // test_case1
		int test_case2 = 0;
		test_case = Integer.parseInt(bf.readline()); // input test_case's count
		
		for(int i = 0; i< test_case; i++){
		    test_case2 = Integer.parseInt(bf.readline()); // input test_case2(heap's size)
		    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); // 최소 heap 선언
		    PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		                                                                // 최대 heap 선언 
		    
		    for(int i = 0 ; i < test_case2; i++){
		       heap.add(bf.read()); // 최소 heap에 값을 한개씩 입력한다.
		       heap2.add(bf.read()); // 최대 heap에 값을 한개씩 입력한다.
		    }
		    for(int i = 0; i < test_case2/2 ; i+=2){ // 홀수인 index마다 출력 시키기로한다.
		        System.out.println(test_case2/2 + 1); // test_case의 중간값이 몇 개 인지 출력한다.
		                                               // ex) text_case2 = 9 -> 5
		        int middle = heap.peek() + heap2.peek()
		    }
		    
		    heap.clear(); // 새로운 값을 입력받기 위해서 heap을 정리한다.
		}

		
	}
}
