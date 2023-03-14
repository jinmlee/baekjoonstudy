package backjoon;

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int max = 0;
        int num69 = 0;

        String room = Integer.toString(num);

        int[] numStr = new int[10];

        for(int i = 0; i < room.length(); i++){
            numStr[room.charAt(i) - '0']++;
        }
        for(int i = 0; i < 10; i++){
            if(numStr[i] > max && i != 6 && i != 9)
                max = numStr[i];
        }

        num69 = (numStr[6] + numStr[9]) / 2;
        if((numStr[6] + numStr[9]) % 2 == 1)
            num69 += 1;

        if(max < num69)
            max = num69;

        System.out.print(max);

    }
}
