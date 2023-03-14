package backjoon;

import java.util.Scanner;

public class ex00 {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            int[] count = new int[26];

            for (int i = 0; i < str.length(); i++){
                count[str.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                System.out.print(count[i] + " ");
            }
        }
}
