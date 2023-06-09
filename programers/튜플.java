package programers;
import java.util.*;
public class 튜플 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] answer;


        HashMap<String, Integer> hashMap = new HashMap<>();
        String num = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) <= '9' && s.charAt(i) >= '0')
                num += s.charAt(i);
            else if(num != ""){
                if(hashMap.containsKey(num)){
                    int newVal = hashMap.get(num) + 1;
                    hashMap.put(num, newVal);
                }
                else
                    hashMap.put(num, 1);
                num = "";
            }
        }
        answer = new int[hashMap.size()];

        int[] map = new int[s.length() + 1];
        for (String key : hashMap.keySet()) {
            int value = hashMap.get(key);
            int arr = Integer.parseInt(key);
            map[value] = arr;
        }
        int idx = 0;
        for(int i = s.length(); i >= 0; i--){
            if(map[i] > 0){
                answer[idx] = map[i];
                idx++;
                System.out.println(map[i]);
            }
        }
    }
}
