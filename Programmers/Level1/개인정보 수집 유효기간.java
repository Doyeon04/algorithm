   
import java.util.*; 

class Solution {
    
    public int convertToDate(String day){
        return Integer.parseInt(day.substring(0, 4)) * 12 * 28 + 
                        Integer.parseInt(day.substring(5, 7)) * 28 + 
                        Integer.parseInt(day.substring(8)); 
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>(); 

        int i=0; 
        for(String p : privacies){
            i++; 
            String[] split = p.split(" "); 
            int month = 0; 
            for(String t : terms){
                  if(t.substring(0, 1).equals(split[1])){
                    month = Integer.parseInt(t.substring(2));
                    break;
                }
            }
            if((month * 28)+convertToDate(split[0]) <= convertToDate(today)){   // 개인정보 수집일짜 + 유효기간 < 오늘날짜 면 파기해야함
                answer.add(i); 
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray(); 
    }
}