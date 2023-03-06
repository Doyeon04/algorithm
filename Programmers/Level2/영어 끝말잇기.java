/*
탈락하는 사람 찾으면-i%n, i/n 반환
    1. set에 포함된 단어면
    2. 이전사람 마지막 알파벳으로 안시작하면
*/
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();

        char last = ' '; 
        
        for(int i=0; i<words.length; i++){
            if(set.contains(words[i]) || (i!= 0 && last != words[i].charAt(0))){
                    answer[0] = i%n+1;
                    answer[1] = i/n+1;
                break; 
            }
            set.add(words[i]); 
            last = words[i].charAt(words[i].length()-1); 
        }
        return answer;
    }
}