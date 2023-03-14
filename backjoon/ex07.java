package backjoon;

import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        int remove = 0;

        for(int i = 0; i < a.length(); i++){
            count1[a.charAt(i) - 'a']++;
        }
        for(int i = 0; i < b.length(); i++){
            count2[b.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(count1[i] - count2[i] < 0)
                remove += (count1[i] - count2[i]) * -1;
            else
                remove += count1[i] - count2[i];
        }

        System.out.println(remove);
    }
}
