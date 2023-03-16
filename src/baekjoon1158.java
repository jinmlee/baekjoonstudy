import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        Queue<Integer> person = new LinkedList<>();
        for(int i = 1; i <=n; i++){
            person.offer(i);
        }
        int count = 0;

        StringBuilder rmNumber = new StringBuilder();
        rmNumber.append("<");
        while(!person.isEmpty()){
            count++;
            if(count % k == 0){
                rmNumber.append(person.poll());
                if(person.size() > 0){
                    rmNumber.append(", ");
                }
            }
            else
                person.offer(person.poll());
        }
        rmNumber.append(">");

        System.out.println(rmNumber);
    }
}
