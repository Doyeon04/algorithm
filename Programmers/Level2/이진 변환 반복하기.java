/*
1. x를 순회하면서 0이면 cnt하고 제거(replace(x, ""))
2. x의 길이를 구함 - c
3. c가 1이 될때까지 2로 계속 나눈 나머지들을 붙임
4. 1,2,3 과정을 s가 1이 될때까지 반복
*/

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2]; 
      
        while(!s.equals("1")){
            answer[0]++; 
            for(char c : s.toCharArray()){
                if(c=='0') answer[1]++;
            }
            s = s.replace("0", ""); 
            int c = s.length(); 
            s = ""; 
            while(c>0){
                s += c % 2;  
                c /= 2; // 몫
            }
        }
        
        return answer;
    }
}

