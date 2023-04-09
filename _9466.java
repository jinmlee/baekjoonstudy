package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class _9466 {
    static int N;
    static int[] student;
    static int[] visit;
    static Deque<team> q = new LinkedList<>();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            student = new int[N + 1];
            visit = new int[N + 1];
            String[] str = br.readLine().split(" ");
            for (int n = 1; n <= N; n++) {
                student[n] = Integer.parseInt(str[n - 1]);
            }

            for (int n = 1; n <= N; n++) {
                if (visit[n] == 0) {
                    q.add(new team(n));
                    visit[n] = 1;
                    bfs();
                }
                q.clear();
            }
            System.out.println(cnt);
            cnt = 0;
        }

    }

    static void bfs(){
        while(!q.isEmpty()){
            int x = q.peekLast().x;
            if(student[x] <= N  && visit[student[x]] == 0) {
                q.addLast(new team(student[x]));
                visit[student[x]] = 1;
            }
            else{
                if(student[x] != q.peekFirst().x) {
                    cnt++;
                    q.removeFirst();
                }
                else
                    return ;
            }
        }
    }

    static class team{
        int x;
        public team(int x){
            this.x = x;
        }
    }
}
