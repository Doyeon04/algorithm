class Solution
{
    
    public int solution(int n, int a, int b)
    {
        int answer = 0;
    
        while(a!=b){
            answer++; 
           
            if(a%2==0) a/=2;
            else a=a/2+1;
        
            if(b%2==0) b/=2;
            else b=b/2+1;
        }
        return answer;
    }
}
/*
4->2->1->1
7->4->2->1
*/