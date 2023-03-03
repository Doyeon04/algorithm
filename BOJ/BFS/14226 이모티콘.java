import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int s;
    static int answer = Integer.MAX_VALUE;
    static boolean[][] visit = new boolean[1001][1001];

    static class Emoticon {
        int clip, screen, cnt;

        public Emoticon(int screen, int clip, int cnt) {
            this.screen = screen;
            this.clip = clip;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Queue<Emoticon> queue = new LinkedList<>();
        queue.add(new Emoticon(1, 0, 0));

        visit[1][0] = true;

        while (!queue.isEmpty()) {
            Emoticon v = queue.poll();
            int clip = v.clip;
            int screen = v.screen;
            int cnt = v.cnt;

            if (screen == s) {
                answer = cnt;
                break;
            }

            if (!visit[screen][screen]) { // 이모티콘 복사
                visit[screen][screen] = true;
                queue.offer(new Emoticon(screen, screen, cnt + 1));
            }
            if (screen+clip < 1001 && !visit[screen + clip][clip]) { // 클립보드에 있는 이모티콘 화면에 붙여넣기
                visit[screen + clip][clip] = true;
                queue.offer(new Emoticon(screen + clip, clip, cnt + 1));
            }
            if (screen-1>=0 && !visit[screen - 1][clip] ) { // 화면에 있는 이모티콘 하나 삭제
                visit[screen - 1][clip] = true;
                queue.offer(new Emoticon(screen - 1, clip, cnt + 1));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        bfs();

        System.out.println(answer);
    }
}