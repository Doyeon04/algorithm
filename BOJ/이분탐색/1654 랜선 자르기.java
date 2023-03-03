import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];
        for(int i=0; i<k; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        // n개를 만들 수 있는 랜선의 최대 길이

        long left = 1; // 랜선 길이는 자연수
        long right = arr[k-1];
        long answer = 0;
        while(left<=right){
            long mid = (left+right)/2; // 자르는 길이
            int cnt = 0;
            for(long length : arr){
                cnt += length / mid;
            }
            if(cnt >= n){ // 자른 개수가 n보다 같거나 크면
                left = mid+1; // 자른 개수를 작게하기 위해 자르는 길이를 크게 함
                // answer = Math.max(answer, mid);
            }else{ // 자른 개수가 n보다 작으면
                right = mid-1; // 자른 개수를 크게 하기 위해 자르는 길이를 작게 함
            }
        }
        System.out.println(right);
    }
}