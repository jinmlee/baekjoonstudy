package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] str = new int[n];

        for(int i = 0; i < n; i++)
            str[i] = sc.nextInt();
        int value = sc.nextInt();
        int count = 0;


        Arrays.sort(str);

        int left = 0;
        int right = n - 1;
        while(left < right){
            if (str[left] + str[right] == value) {
                count++;
                left++;
                right--;
            } else if (str[left] + str[right] < value){
                left++;
            }
            else
                right--;
        }

        System.out.print(count);

    }
}
