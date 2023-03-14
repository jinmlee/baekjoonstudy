package backjoon;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int num = a * b * c;

        String numStr = Integer.toString(num);
        int[] count = new int[10];

        for(int i = 0; i < numStr.length(); i++)
        {
            count[numStr.charAt(i) - '0']++;
        }
        for(int i = 0; i < 10; i++)
        {
            System.out.println(count[i]);
        }

    }
}
