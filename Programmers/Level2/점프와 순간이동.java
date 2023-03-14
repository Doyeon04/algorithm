import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
    
        while(n>0){
            if(n%2==0){
                n/=2;
            }else{
                n--;
                ans++; 
            }    
        }
        
        return ans;
    }
}
/*
k칸 점프(k만큼 건전지 사용) or 순간이동(건전지 사용x, 현재까지 온거리x2 위치로 이동)
점프 최소로 n만큼 이동할 때 건전지 사용 최솟값 
*/