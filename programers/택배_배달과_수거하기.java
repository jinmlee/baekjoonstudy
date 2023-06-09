package programers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 택배_배달과_수거하기 {
    public static void main(String[] args) {
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        int[] box = new int[2];
        int answer = 0;

        for(int i = n - 1; i >= 0; i--){
            box[0] = cap;
            box[1] = cap;
            if(deliveries[i] <= 0 && pickups[i] <= 0)
                continue;

            for(int j = i; j >= 0; j--){
                if(deliveries[j] == 0)
                    continue;
                if(deliveries[j] <= box[0]){
                    box[0] = box[0] - deliveries[j];
                    deliveries[j] = 0;
                }else{
                    deliveries[j] -= box[0];
                    break;
                }
            }
            for(int j = i; j >= 0; j--){
                if(pickups[j] == 0)
                    continue;
                if(pickups[j] <= box[1]){
                    box[1] = box[1] - pickups[j];
                    pickups[j] = 0;
                }else{
                    pickups[j] -= box[1];
                    break;
                }
            }
            answer += (i + 1) * 2;
            if(deliveries[i] > 0 || pickups[i] > 0){
                i += 1;
            }
        }

        System.out.println(answer);
    }
}
