import java.util.*; 

/*
1. 중복 없이 (신고한 사람 : 신고 당한 사람) 넣어야 함 -> set
2. (신고 당한 사람: 카운트) (유저 : 유저 번호) map 
3. (신고 당한 사람 : 신고 당한 횟수) 저장
4. 신고 받은 사람 카운트가 k이상이면 그 사람을 신고한 사람(유저 번호로 접근)의 메일수를 1증가
*/

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; 
        
        HashSet<String> set = new HashSet<>(); 
        
        for(String r : report){ // 1
            set.add(r); 
        } 
        
        HashMap<String, Integer> reportMap = new HashMap<>(); // 신고 당한 사람 : 신고 당한 횟수 
        HashMap<String, Integer> userMap = new HashMap<>(); // 유저 이름 : 인덱스
        
        int i=0; 
        for(String user : id_list){ // 2
            reportMap.put(user, 0); 
            userMap.put(user, i++); 
        }
        for(String s : set){ // 3
            String[] split = s.split(" ");
            reportMap.put(split[1], reportMap.get(split[1])+1); 
        }
        
        for(String s : set){ // 4
            if(reportMap.get(s.split(" ")[1])>=k){ // 신고 받은 사람 카운트가 k이상이면 
                answer[userMap.get(s.split(" ")[0])]++; 
            }
        }
        
        return answer;
    }
}