package backjoon;

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int limit = sc.nextInt();
        int[][] student = new int[2][6];
        int s, y;
        int count = 0;

        for(int i = 0; i < n; i++){
            s = sc.nextInt();
            y = sc.nextInt();
            student[s][y - 1]++;
        }

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 6; j++){
                count += student[i][j] / limit;
                if((student[i][j] % limit) != 0)
                    count++;
            }
        }

        System.out.println(count);
    }
}
