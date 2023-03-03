import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int left = Arrays.stream(arr).max().getAsInt(); // 최댓값
        int right = Arrays.stream(arr).sum(); // 합계

        while(left<=right){
            int mid = (left+right) / 2; // 블루레이 한 개의 강의 용량
            if(count(mid) <= m){ // 블루레이 개수가 m보다 작거나 같으면
                answer = mid;
                right = mid - 1; // 블루레이 개수를 늘리기 위해 강의 용량을 줄인다.
            }
            else left = mid + 1;
        }
        System.out.println(answer);
    }

    static int count(int capacity){
        int cnt = 1;
        int sum = 0;

        for(int lecture : arr){
            if(sum + lecture > capacity){ // 강의를 담았을 때 한 블루레이의 용량을 넘어가버리면
                cnt++; // 블루레이 개수 한개 증가
                sum = lecture; // 새로운 값으로 갱신
            }
            else sum+=lecture;
        }
        return cnt;  // 블루레이 한개의 용량을 capacity로 했을 때 필요한 블루레이의 개수
    }
}