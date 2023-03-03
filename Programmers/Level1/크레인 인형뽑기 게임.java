import java.util.*;

/*
2차원 배열 탐색하려는 줄에 가서 for문으로 위에서 아래로 탐색하며 숫자 만나자마자 스택에 push 함
push 할 때 이전 스택 값이랑 같으면 둘다 터지고 answer에 추가
*/
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>(); 
        
        for(int m : moves){
            for(int i=0; i<board.length; i++){ // 위에서 아래로 탐색
                if(board[i][m-1]!=0){ // 인형이 있으면
                    if(!stack.isEmpty() && stack.peek()==board[i][m-1]){ // 같은 모양의 인형이면
                        stack.pop(); 
                        answer+=2; 
                    }else stack.push(board[i][m-1]);
                    
                    board[i][m-1] = 0; // 빈칸으로 바꿈
                    break;
                }
            }
            
        }
        
        return answer;
    }
}