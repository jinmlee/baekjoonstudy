package programers;

import static java.lang.Math.*;

public class 점찍기 {
    public static void main(String[] args) {
        int k = 1;
        int d = 5;

        long answer = 0;
        long p = d;
        for(long y = 0; y <= d; y += k){
            answer += (long)(Math.sqrt(p*p - y*y) / k) + 1;
        }
        System.out.println(answer);


    }
}
