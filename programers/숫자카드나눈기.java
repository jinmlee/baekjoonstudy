package programers;

import java.util.Arrays;

public class 숫자카드나눈기 {
    public static void main(String[] args) {
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};

        int max = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int a = arrayA[0];
        int b = arrayB[0];

        for(int i = a; i > 1; i--){
            int check= 0;
            for(int j = 0; j < arrayA.length; j++){
                if(arrayA[j] % i != 0 || arrayB[j] % i == 0) {
                    check = 1;
                    break;
                }
            }
            if(check == 0) {
                max = i;
                break;
            }
        }
        for(int i = b; i > max; i--){
            int check= 0;
            for(int j = 0; j < arrayA.length; j++){
                if(arrayB[j] % i != 0 || arrayA[j] % i == 0) {
                    check = 1;
                    break;
                }
            }
            if(check == 0) {
                max = i;
                break;
            }
        }

        System.out.println(max);
    }
}
