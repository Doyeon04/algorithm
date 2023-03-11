import java.util.*;

class Solution {
    public boolean isPrime(long n){ 
        if(n==1) return false; 
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true; 
    }
    public int solution(int n, int k) {
        int answer = 0;
        
        String converted = "0"; 
        while(n>0){
            int rest = n % k;
            converted = rest + converted; 
            n /= k; 
        }
 
        String each = ""; 
        for(char c : converted.toCharArray()){
            if(c!='0'){
                each+=c;
            }else if(!each.equals("")){
                if(isPrime(Long.parseLong(each))) answer++;
                each=""; 
            }
        }
        // for(String s : converted.split("0")){
        //     if(!s.equals("")){
        //         if(isPrime(Long.parseLong(s))) answer++; 
        //     }
        // }
        return answer;
    }
}
/*
-n -> k진수로 바꿈
-0 나오면 문자열을 잘라서 배열에 넣음 [211, 2, 1, 1, 11]
-배열 원소들이 소수인지 아닌지 판별 
*/
