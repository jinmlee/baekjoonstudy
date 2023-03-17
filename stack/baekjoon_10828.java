import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        int index = 0;


        for(int i = 0; i < n; i++){
            String[] option = br.readLine().split(" ");
            switch(option[0]){
                case "push":
                    stack.add(Integer.parseInt(option[1]));
                    index++;
                    break;
                case "pop":
                    if(index == 0)
                        System.out.println(-1);
                    else {
                        index--;
                        System.out.println(stack.get(index));
                        stack.remove(index);
                    }
                    break;
                case "size":
                    System.out.println(index);
                    break;
                case "empty":
                    if(index > 0)
                        System.out.println(0);
                    else
                        System.out.println(1);
                    break;
                case "top":
                    if(index > 0)
                        System.out.println(stack.get(index - 1));
                    else
                        System.out.println(-1);
            }
        }
    }
}
