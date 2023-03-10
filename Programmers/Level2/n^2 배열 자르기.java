class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left);
        int[] answer = new int[size+1]; 
        
        int[][] arr = new int[n][n];
        
        int k = 0; 
        for(int i=0; i<arr.length; i++){
            k=i+1;
            int tmp = 0; 
            for(int j=0; j<arr.length; j++){ 
                if(k-1>=j) {
                    arr[i][j] = k;
                    tmp = k;
                }else arr[i][j] = ++tmp; 
            }
        }
        int i=0; 
        while(left<=right){
            answer[i++]= arr[(int)left/n][(int)left%n];
            left++;
        }

        return answer;
    }
}
/*
arr[left / n][left % n] 에서 left가 right 이 될 때까지 left++하며 값을 answer배열에 추가
*/