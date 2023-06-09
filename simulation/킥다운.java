package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 킥다운 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        if(str2.length() > str1.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        String[] gear1 = str1.split("");
        String[] gear2 = str2.split("");

        int min = gear2.length + gear1.length;
        for(int i = 0; i < gear1.length; i++){
            int idx1 = i;
            int idx2 = gear2.length - 1;
            while(idx1 >= 0 && idx2 >= 0){
                if(gear1[idx1].equals("2") && gear2[idx2].equals("2"))
                    break;
                idx2--;
                idx1--;
            }
            if(idx1 < 0 || idx2 < 0){
                int size;
                if(i < gear2.length){
                    size = gear2.length - 1 - i +gear1.length;
                }else
                    size = gear1.length;
                if(min > size)
                    min = size;
            }
        }
        for(int i = 0; i < gear2.length; i++){
            int idx1 = gear1.length - 1;
            int idx2 = i;
            while(idx2 >= 0){
                if(gear1[idx1].equals("2") && gear2[idx2].equals("2"))
                    break;
                idx2--;
                idx1--;
            }
            if(idx1 < 0 || idx2 < 0){
                int size = gear2.length - i - 1 + gear1.length;
                if(min > size)
                    min = size;
            }
        }

        System.out.println(min);
    }
}
