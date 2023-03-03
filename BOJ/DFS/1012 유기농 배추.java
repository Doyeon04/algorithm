import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n, m, k;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void dfs(int y, int x){

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=m || ny<0 || ny>=n || arr[ny][nx]==0) continue;

            arr[ny][nx] = 0;
            dfs(ny, nx);

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][m];

            while(k-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j] == 1){
                        cnt++;
                        arr[i][j] =0;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}