/*
2 : 2가 제일 앞 / 2
2 1 : 그 다음에 1  / 2 1
1 2 3 : 그 다음에 3 / 2 1 3
1 2 4 3 : 그 다음에 4 / 2 1 3 4 

작은 길이의 부분집합일 수록 먼저 먼저 온 것임

1. 부분집합에 길이에 따라서 정렬(길이 증가하는 순으로)
    1-1. string -> int형 arr로 
2. 그 후 차례대로 순회하면서 set만들어 원소 넣음 
3. set을 입력한대로(linkedHashSet) 쭉 출력하면 됨
*/
import java.util.*; 

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-1); // 앞뒤 제거
        Stack<Character> stack = new Stack<>(); 
        List<String> list = new ArrayList<>(); 
        
        String each = ""; 
        for(char c : s.toCharArray()){
            if(c == '{') stack.push(c);
             else if(c == '}'){
                stack.pop();
                list.add(each);
                each=""; 
            }
            else{
                if(!stack.isEmpty() && stack.peek()=='{') each+=c; 
            }
        }

        Collections.sort(list, (String a, String b) -> a.length() - b.length()); // 1 
        
        Set<Integer> set = new LinkedHashSet<>();
        
        for(String l : list){
            for(String num : l.split(",")){
                set.add(Integer.parseInt(num)); // 2
            }
        }
        int[] answer = new int[set.size()]; 
        int i=0; 
        for(int x : set){ // 3
            answer[i++] = x;    
        }
        return answer;
    }
}