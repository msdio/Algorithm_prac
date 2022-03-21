import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pracAlgo {
    static StringBuilder sb = new StringBuilder();
    static BufReader scan = new BufReader();


    static int N;
    static long[] nums;


    static void input() {
        N = scan.nextInt();

        nums = new long[N];
        for(int i=0; i<N; i++) {
            nums[i] = scan.nextLong();
        }
    }


    static void pro() {
        Arrays.sort(nums);

        int max = 0;
        int count = 0;
        long ans = nums[0];

        for(int i=1; i<N; i++) {
            if(nums[i-1] == nums[i]) {
                count++;
            } else {
                count = 0;
            }

            if(count > max) {
                max = count;
                ans = nums[i];
            }
        }

        System.out.println(ans);
    }



    public static void main(String args[]) {
        input();

        pro();
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
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}