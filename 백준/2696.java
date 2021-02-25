import java.io.*;
import java.util.PriorityQueue;

public class Main
{
	public static void main(String[] args) {
	    
		BufferedReader bf = new BufferedReader(new inputStreamReader(System.in));
		
		int test_case = 0; // test_case1
		int test_case2 = 0;
		test_case = Integer.parseInt(bf.readline()); // input test_case's count
		
		for(int i = 0; i< test_case; i++){
		    test_case2 = Integer.parseInt(bf.readline()); // input test_case2(heap's size)
		    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); // declare heap
		    
		    for(int i = 0 ; i < test_case2; i++){
		       heap.add(bf.read()); // heap에 값을 한개씩 입력한다.
		    }
		    
		    heap.clear(); // 새로운 값을 입력받기 위해서 heap을 정리한다.
		}

		
	}
}
