package queue;

import java.io.*;

public class baekjoon_10258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue q = new Queue();

        for(int i = 0; i < n; i++){
            String[] option = br.readLine().split(" ");

            switch (option[0]){
                case "push":
                    q.push(Integer.parseInt(option[1]));
                    break;
                case "front":
                    bw.write(q.front() + "\n");
                    break;
                case "back":
                    bw.write(q.back() + "\n");
                    break;
                case "size":
                    bw.write(q.size + "\n");
                    break;
                case "empty":
                    bw.write(q.empty() + "\n");
                    break;
                case "pop":
                    bw.write(q.pop() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
    }

    static class Queue{
        Node head;
        Node tail;
        int size = 0;

        public Queue(){
            head = null;
            tail = null;
        }

        class Node{
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        public void push(int data){
            Node newNode = new Node(data);
            if(head == null) {
                head = newNode;
            } else{
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        }

        public int pop(){
            if(head == null)
                return -1;
            else{
                int num = head.data;
                head = head.next;
                size--;
                return num;
            }
        }

        public int empty(){
            if(head == null)
                return 1;
            else
                return 0;
        }

        public int front(){
            if(head == null)
                return -1;
            else
                return head.data;
        }

        public int back(){
            if(head == null)
                return -1;
            else
                return tail.data;
        }
    }
}
