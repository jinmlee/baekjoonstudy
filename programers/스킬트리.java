package programers;

import java.util.HashMap;

public class 스킬트리 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < skill_trees.length; i++){
            String[] str = skill_trees[i].split("");
            for(int j = 0; j < str.length; j++){
                map.put(str[j], j);
            }
            int idx = -1;
            int j;
            str = skill.split("");
            int[] check = new int[str.length];
            for(j = 0; j < str.length; j++){
                if(map.containsKey(str[j])){
                    if(j > 0 && check[j-1] == 0)
                        break;
                    if(idx < map.get(str[j])) {
                        idx = map.get(str[j]);
                        check[j] = 1;
                    }
                    else
                        break;
                }
            }
            if(j >= str.length) {
                answer++;
            }
            map.clear();
        }
        System.out.println(answer);
    }
}
