package backjoon;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numArr = new int[201];
        int num = 0;
        for(int i = 0; i < n; i++){
            num = sc.nextInt() + 100;
            numArr[num]++;
        }
        int v = sc.nextInt();

        System.out.print(numArr[v + 100]);

    }
}
