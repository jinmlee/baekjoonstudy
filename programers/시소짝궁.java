package programers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class 시소짝궁 {
    public static void main(String[] args) {
        int[] weights = {100,180,360,100,270};
        int answer = 0;

        Arrays.sort(weights);

        int cnt = 0;
        for(int i =0; i < weights.length - 1; i++){
            int t1 = weights[i] * 2;
            int t2 = weights[i] * 3;
            int t3 = weights[i] * 4;
            if(i > 0 && weights[i] == weights[i - 1]){
                cnt--;
                answer += cnt;
                continue;
            }
            cnt = 0;
            if(weights[i + 1] > t1)
                break;
            for(int k = i + 1; k < weights.length; k++) {
                for (int j = 2; j < 5; j++) {
                    if (weights[k] * j == t1 || weights[k] * j == t2 || weights[k] * j == t3){
                        cnt++;
                        break;
                    }
                }
            }
            answer += cnt;
        }
        System.out.println(answer);
    }
}
