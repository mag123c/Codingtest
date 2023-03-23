import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; 
        HashMap<String, Integer> idMap = new HashMap<>(); 
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        for(int i=0; i<id_list.length;i++){
            idMap.put(id_list[i],i);
            map.put(id_list[i],new HashSet<>());
        }
        
        for(String r : report){
            String[] str = r.split(" ");
            map.get(str[1]).add(str[0]);
        }
        
        for(int i=0; i<id_list.length;i++){
            HashSet<String> set = map.get(id_list[i]); 
            if(set.size() >= k){
                for(String userId : set){
                    answer[idMap.get(userId)]++;
                }
            }
        }
        
        return answer;
    }
}