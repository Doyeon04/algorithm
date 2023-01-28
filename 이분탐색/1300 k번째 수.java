import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = k;
        long answer = 0;
        while(left<=right){
            long mid = (left+right) / 2; // 임의의 값을 중간값으로 잡음
            long cnt = 0; // mid보다 작거나 같은 원소의 개수

            for(int i=1; i<=n; i++){
                cnt += Math.min(mid / i, n); // 임의의 mid값에 대해 i번째 행(각 단)을 나눠서 각 행마다 mid보다 작거나 같은 원소의 개수를 구해 누적한다.
                // 각 행에서 mid보다 작은 원소의 개수는 n보다 커질 수 없다.
            }
            if(cnt<k){
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);

    }
}