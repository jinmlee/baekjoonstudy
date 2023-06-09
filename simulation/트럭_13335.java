package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 트럭_13335 {
    static Queue<Integer> truck = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int w = Integer.parseInt(str[1]);
        int l = Integer.parseInt(str[2]);
        str = br.readLine().split(" ");
        for(int i = 0; i < str.length; i++){
            truck.add(Integer.parseInt(str[i]));
        }
        System.out.println(move(w, l));
    }
    static int move(int w, int l){
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int size = 0;
        while(!truck.isEmpty()){
            time++;
            if(q.size() == w){
                size -= q.poll();
            }
            if(size + truck.peek() <= l){
                size += truck.peek();
                q.add(truck.poll());
            }else{
                q.add(0);
            }
        }
        time += w;
        return time;
    }
}
