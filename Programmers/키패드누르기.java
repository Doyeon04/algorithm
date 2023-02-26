import java.util.*;

/*
1 2 3
4 5 6
7 8 9
* 0 #

1, 4, 7 은 무조건 왼손
3, 6, 9 는 무조건 오른손
2, 5, 8, 0 은 더 가까운 손. 거리 같다면 왼손잡이면 왼손, 오른손잡이면 오른손 

(1, 3)에서 (2,2)까지 거리? => 2
*/

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] pad = {{3, 1}, 
                       {0, 0}, {0, 1}, {0, 2}, 
                       {1, 0}, {1, 1}, {1, 2},
                       {2, 0}, {2, 1}, {2, 2}};
        
        int[] right = {3, 0}; // 현재 오른손 위치
        int[] left = {3, 2}; // 현재 왼손 위치
        
        // 현재 위치 저장해야함 (x, y) 형태로? 
        for(int i=0; i<numbers.length; i++){
            int n = numbers[i]; 
            if(n == 1 || n == 4 || n == 7){
                // 왼손
                left[0] = pad[n][0];
                left[1] = pad[n][1]; 
                answer+= "L"; 
            }
            else if(n == 3 || n == 6 || n == 9){
                // 오른손
                right[0] = pad[n][0];
                right[1] = pad[n][1]; 
                answer+= "R"; 
                
            }
            else{ // 2, 5, 8, 0 이면 더 가까운 손
                int rightDis = Math.abs(right[0] - pad[n][0]) + Math.abs(right[1] - pad[n][1]); 
                int leftDis = Math.abs(left[0] - pad[n][0]) + Math.abs(left[1]-pad[n][1]); 
                
                if(rightDis > leftDis){
                   left[0] = pad[n][0];
                   left[1] = pad[n][1]; 
                   answer+= "L"; 
                }
                else if(rightDis < leftDis){
                      right[0] = pad[n][0];
                      right[1] = pad[n][1]; 
                      answer+= "R"; 
                }else{ // 두 거리가 같으면
                    if(hand.equals("left")){
                        left[0] = pad[n][0];
                        left[1] = pad[n][1]; 
                        answer+= "L"; 
                    }
                    else{
                        right[0] = pad[n][0];
                        right[1] = pad[n][1]; 
                        answer+= "R"; 
                    }
                }
            }
            
        }
        
        return answer;
    }
}