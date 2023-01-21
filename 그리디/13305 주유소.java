import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int[] cityLength = new int[n-1]; // 인접한 두 도시를 연결하는 도로의 길이
        long [] cost = new long[n]; // 기름 값
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            cityLength[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;
        long minPrice = cost[0];

        for(int i=0; i<n-1; i++){
            minPrice = Math.min(minPrice, cost[i]);
            total +=  minPrice * cityLength[i];
            //System.out.println("minPrice:"+minPrice+" total:"+total);
        }
        System.out.println(total);
    }
}