import java.io.*;
import java.util.Stack;

public class baekjoon5397 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int k = 0; k < str.length(); k++) {
                char c = str.charAt(k);
                switch (c){
                    case '-' :
                        if (!left.isEmpty())
                            left.pop();
                        break;
                    case '>' :
                        if(!right.isEmpty())
                             left.push(right.pop());
                        break;
                    case '<' :
                        if(!left.isEmpty())
                            right.push(left.pop());
                        break;
                    default:
                        left.push(c);
                        break;
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                bw.write(right.pop());
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
