import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] unf;
    static StringBuilder sb = new StringBuilder();
    public static int find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }
    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i] = i;

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x==0){ // a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다
                    union(a, b);
            }else{ // 두 원소가 같은 집합에 포함되어 있는지를 확인
                if(find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}