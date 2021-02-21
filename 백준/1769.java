import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        int input = Integer.parseInt(br.readLine());

        if(input > 9999999){
            return;
        }
        int count = 0;

        while(true){
            if(input % 10 == input && input < 10)
                break;
            input = check(input);
            count++;
        }

        if(input % 3 == 0){
            System.out.println(count);
            System.out.println("YES");
        }
        if(input % 3 != 0){
            System.out.println(count);
            System.out.println("NO");
        }
    }
    public static int check(int input){
        int output = 0;
        while(true){
            if(input == 0){
                break;
            }
            output += input % 10;
            input /= 10;
        }
        return output;
    }
}
