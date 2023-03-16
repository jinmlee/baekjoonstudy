import java.io.*;
import java.util.Stack;


public class baekjoon1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        int n = Integer.parseInt(bf.readLine());
        Stack<String> left = new Stack();
        Stack<String> right = new Stack();
        String option;
        char c; //option P로 받는 새 문자

        String[] arr = str.split("");

        for (String s: arr
             ) { left.push(s);

        }


        for(int i = 0; i < n; i++){
            option = bf.readLine();
            if(option.charAt(0) == 'P'){
                c = option.charAt(2);
                left.push(String.valueOf(c));
            }
            if(option.charAt(0) == 'L' && !(left.empty())){
                right.push(left.pop());
            }
            if(option.charAt(0) == 'D' && !(right.empty())){
                left.push(right.pop());
            }
            if(option.charAt(0) == 'B' && !(left.empty())){
                left.pop();
            }
        }

        while(!(left.empty())){
            right.push(left.pop());
        }
        while(!(right.empty())){
            bw.write(right.pop());
        }
        bw.flush();
        bw.close();
    }
}
