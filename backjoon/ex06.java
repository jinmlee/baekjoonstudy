package backjoon;

import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();

            int[] alpa1 = new int[26];
            int[] alpa2 = new int[26];
            for (int j = 0; j < a.length(); j++) {
                alpa1[a.charAt(j) - 'a']++;
            }
            for(int p = 0; p < b.length(); p++){
                alpa2[b.charAt(p) - 'a']++;
            }
            int check = 0;

            for (int k = 0; k < 26; k++) {
                if (alpa1[k] != alpa2[k]) {
                    check = 1;
                    break;
                }
            }

            if (check == 1)
                System.out.println("Impossible");
            else
                System.out.println("Possible");
        }
    }
}
