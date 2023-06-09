package programers;

import java.util.LinkedList;
import java.util.*;

public class 괄호변환 {
    static Deque<String> q = new LinkedList<>();
    static String u = "";
    static String v = "";
    public static void main(String[] args) {
        String p = "(()())()";

        String answer = "";
        int start = 0;
        int back = 0;


        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(')
                start++;
            else
                back++;
            if(start < back) {

            }else{
                answer += p.charAt(i);
            }
        }
        System.out.println(answer);
    }
    static void fun(){

    }
}
