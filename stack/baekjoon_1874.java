import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        Stack<Character> plma = new Stack<>();
        int max = n;

        for(int i = 0; i < n; i++){
            left.push(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < n; i++){
            right.push(left.pop());
            plma.push('-');
            if(right.peek() == max){
                while(!right.isEmpty() && right.peek() == max){
                    right.pop();
                    plma.push('+');
                    max--;
                }
            }
        }

        if(plma.size() == n*2) {
            while (!plma.isEmpty()) {
                System.out.println(plma.pop());
            }
        }
        else
            System.out.println("NO");

    }
}
