import java.util.ArrayList;
import java.util.Collections;

public class Solution {


	String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		ArrayList<Integer> timeList = new ArrayList<>();

		for(int i=0; i<timetable.length; i++) {
			timeList.add(timetableInteger(timetable[i]));
		
		}
        
        Collections.sort(timeList);

		
		int start=540;
		int cnt=0;
		int length=0;
		int lastManTime=0;
		
		for(int i=0; i<n; i++) {
			cnt=0;
			

			if(length>=timeList.size()) {
				break;
			}
			

			while(cnt<m) {
				if(start>=timeList.get(length)) {
					lastManTime = timeList.get(length);
					length++;
					cnt++;
					if(length>=timeList.size()) {
						break;
					}
					
				}

				else {
					break;
				}
			}
			start+=t;
		}
		
		
		if(cnt < m){    
			answer = integerToTimetable(start-t);
        }
		else { 
            answer = integerToTimetable(lastManTime-1);
        }
	        
		System.out.println(answer);
		return answer;

	}	
	
	int timetableInteger(String tt){		
		String[] ttArr = tt.split(":");
		int hours = Integer.parseInt(ttArr[0])*60;
		int minute = Integer.parseInt(ttArr[1]);		
		return hours+minute;
	}
	
	String integerToTimetable(int tt2) {
		String hours = String.valueOf(tt2/60);
		String minute = String.valueOf(tt2%60);
		
		if(hours.length()<2) {
			hours = "0"+hours;
		}
		if(minute.length()<2) {
			minute = "0"+minute;
		}
		String answer = hours+":"+minute;
		return answer;
	}
	
}
