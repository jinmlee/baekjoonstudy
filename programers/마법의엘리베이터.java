package programers;

import java.util.*;

public class 마법의엘리베이터 {
    public static void main(String[] args) {
        int storey = 85;
        int answer = 0;


        while(storey > 0){
            int one = storey % 10;
            storey /= 10;

            if(one > 5){
                answer += 10 - one;
                storey++;
            }else if(one == 5 && storey % 10 >= 5){
                answer += 5;
                storey++;
            }
            else{
                answer += one;
            }
        }
        System.out.println(answer);
    }

}
