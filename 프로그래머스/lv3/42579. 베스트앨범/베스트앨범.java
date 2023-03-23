import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int length = plays.length;
        //1. 속한 노래가 많이 재생된 장르 먼저 수록 -> map에 장르Key, 재생횟수Value
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<length; i++) {
        	map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        //mapKey는 map의 value 내림차순의 Key순서
		ArrayList<String> mapKey = new ArrayList<>(map.keySet());
        Collections.sort(mapKey, (o1, o2) ->
        (map.get(o2).compareTo(map.get(o1))));
        ArrayList<Integer> playsList = new ArrayList<Integer>();
        
        //mapKey의 key값 만큼만 돌리면 해당key일 때의 최고순위 알수있음
        for(int i=0; i<mapKey.size(); i++) {
        	String type = mapKey.get(i);
        	//해당 장르중 가장 큰 값 찾기, 변수들의 각 장르마다 초기화가 필요하다.
        	int max = 0;
        	int idx = -1;
        	for(int j=0; j<length; j++) {
        		if(type.equals(genres[j]) && (max < plays[j])) {
        			max = plays[j];
        			idx = j;
        		}
        	}
        	//두번째 찾기
        	int secidx = -1; max = 0;
        	for(int j=0; j<length; j++) {
        		if(type.equals(genres[j]) && (max < plays[j]) && (j != idx)) {
        			max = plays[j];
        			secidx = j;
        		}
        	}
        	//인덱스 값 넣기. 두번째 인덱스는 없을 수도 있음. -1이 들어가면 안됨
        	playsList.add(idx);
        	if(secidx>=0) playsList.add(secidx);
        }
        
        int ansSize = playsList.size();
        int[] answer = new int[ansSize];
        for(int i=0; i<ansSize; i++) {
        	answer[i] = playsList.get(i);
        }
        
        return answer;
    }
}