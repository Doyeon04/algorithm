import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int answer = 0;
    static boolean[] visited;
    static int[] arr;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    static class Point {
        int v, cnt;

        public Point(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }

    static boolean check(int x) {
        if (x < 0 || x > 100000 || visited[x]) return false;
        return true;
    }

    static void bfs(int v) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(v, 0));
        visited[v] = true;


        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.v;
            int cnt = p.cnt;

            if (x == k) {
                answer = cnt;
                break;
            }

            if (check(x-1)) {
                queue.add(new Point(x - 1, cnt + 1));
                visited[x - 1] = true;
                parent[x-1] = x;
            }
            if (check(x+1)) {
                queue.add(new Point(x + 1, cnt + 1));
                visited[x + 1] = true;
                parent[x+1] = x;
            }
            if (check(x*2)) {
                queue.add(new Point(x * 2, cnt + 1));
                visited[x * 2] = true;
                parent[x*2] = x;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        parent = new int[100001];

        bfs(n);
        System.out.println(answer);

        Stack<Integer> stack = new Stack<>();
        int tmp = k;
        for(int i=0; i<=answer; i++){
            stack.push(tmp);
            tmp = parent[tmp];
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}