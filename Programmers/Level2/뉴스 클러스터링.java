/*
1. 모두 소문자로 바꿈
2. 영어가 아니면 버림
3. 문자열 Hashmap 에 넣음 - 문자 : 원소 개수
4.
    4-1문자열2 돌 때 해당 문자가 map1에 있으면 
        교집합 += min(map2의 value, map1의 value)
        합집합 += max(map2의 value, map2의 value)
    4-2 해당 문자가 map2에 없으면
        합집합++
5.map1 남은 것들 합집합에 추가
*/
import java.util.*; 
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // 1
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase(); 

        // 2,3
        for (int i = 0; i < str1.length()-1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);

            if(('a'<=c1 && c1<='z') && ('a'<=c2 && c2 <='z')){
                String each = (String.valueOf(c1) + String.valueOf(c2));
                map1.put(each, map1.getOrDefault(each, 0)+1);
            }
        }

        for (int i = 0; i < str2.length()-1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if(('a'<=c1 && c1<='z') && ('a'<=c2 && c2 <='z')){
                String each = (String.valueOf(c1) + String.valueOf(c2));
                map2.put(each, map2.getOrDefault(each, 0)+1);
            }
        }
        if(map1.size()==0 && map2.size()==0) return 65536; 
        int same=0;
        int sum =0;

        for(String key : map2.keySet()){
            if(map1.containsKey(key)){ // 4-1
                same+=Math.min(map1.get(key), map2.get(key));
                sum+=Math.max(map1.get(key), map2.get(key));
                map1.remove(key); 
            }else sum+=map2.get(key); // 4-2
        }
        for(String key: map1.keySet()){ // 5
            sum+=map1.get(key); 
        }

        answer = (int)(((double)same/(double)sum) * 65536);
        return answer;
    }
}