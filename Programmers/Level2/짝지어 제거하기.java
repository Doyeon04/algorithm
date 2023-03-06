import java.util.*; 
/*
stack으로 넣을 때 peek()값과 같으면 pop 
*/
class Solution
{
    public int solution(String s)
    {        
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop(); 
            }else stack.push(c); 
        }
        if(stack.size() == 0) return 1;
        else return 0; 

    }
}