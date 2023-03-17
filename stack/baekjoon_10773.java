import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        int totalNum = 0;

        for(int i = 0; i < k; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                list.add(num);
                index++;
            }
            else{
                index--;
                list.remove(index);
            }
        }

        for (int num: list) {
            totalNum += num;
        }
        System.out.println(totalNum);
    }
}
