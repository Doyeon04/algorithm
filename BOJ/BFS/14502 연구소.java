import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int answer = Integer.MIN_VALUE;
    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(){
        int[][] copyArr = new int[n][m];
        Queue<Point> queue = new LinkedList<>();


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copyArr[i][j] = arr[i][j]; // 원본 배열 안망가뜨리게 복사
                if(copyArr[i][j] == 2) queue.add(new Point(j,i)); // 바이러스면 큐에 넣음
            }
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx <0 || nx>=m || ny<0 || ny>=n) continue;

                if(copyArr[ny][nx] == 0){ // 빈칸이면
                    copyArr[ny][nx] = 2; // 바이러스로
                    queue.add(new Point(nx, ny));
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyArr[i][j] == 0) cnt++; // 안정 영역 카운트
            }
        }
        answer = Math.max(answer, cnt);
    }


    static void dfs(int cnt) { // 벽 세우기

        if(cnt == 3){ // 벽 3개 세웠으면
            bfs();
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] ==0){ // 빈칸이면
                    arr[i][j] = 1; // 벽세우기
                    dfs(cnt+1);
                    arr[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs( 0);
        System.out.println(answer);
    }
}
