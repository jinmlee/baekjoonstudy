package programers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 할인행사 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana",};
        int answer = 0;

        for(int i = 0; i < discount.length - 9; i++){
            int k;
            int ten = 0;
            for(k = 0; k < want.length; k++){
                int check = 0;
                for(int j = i; j < i + 10; j++){
                    if(discount[j].equals(want[k])) {
                        check++;
                        ten++;
                    }
                }
                if(check != number[k]) {
                    break;
                }
            }
            if(k == number.length && ten == 10){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
