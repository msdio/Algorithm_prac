import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pracAlgo {
    static StringBuilder sb = new StringBuilder();
    static BufReader scan = new BufReader();


    static int N, M;
    static int[] nums;
    static int[] selected, used;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();

        nums = new int[N+1];
        for(int i=1; i<=N; i++) {
            nums[i] = scan.nextInt();
        }

        selected = new int[M+1];
        used = new int[N+1];
    }


    static void func(int k) {

        if(k == M+1) { //다 고른 경우
            for(int i=1; i<=M; i++) {
                sb.append(selected[i]).append(' ');
            }

            sb.append('\n');
        }
        else { //M개 만큼 숫자들을 선택
            int usedNum = -1;
            for (int i=1; i<=N; i++) {
                if(used[i] == 1) { //사용된 인덱스면 통과
                    continue;
                } else if(usedNum != nums[i]) {
                    selected[k] = nums[i];
                    used[i]=1;
                    usedNum = selected[k];

                    func(k+1);
                    selected[k] = 0;
                    used[i] = 0;
                }

            }
        }
    }


    public static void main(String args[]) {
        input();

        Arrays.sort(nums, 1, N+1);

        func(1);

        System.out.println(sb.toString());
    }



    static class BufReader {
        BufferedReader br;
        StringTokenizer st;

        public BufReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st==null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}