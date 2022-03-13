import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufReader scan = new BufReader();

    static int L, C;
    static char[] alp;
    static int[] selected; //선택받은 알파벳들의 위치

    //입력받는 함수
    static void input() {
        L = scan.nextInt();
        C = scan.nextInt();

        StringTokenizer st = new StringTokenizer(scan.nextLine());

        String[] temp = new String[C+1];
        for(int i=1; i<=C; i++) {
            temp[i] = st.nextToken();
        }

        alp = new char[C+1];
        for(int i=1; i<=C; i++) {
            alp[i] = temp[i].charAt(0);
        }

        selected = new int[L+1];
    }



    static void func(int k) {
        if(k == L+1) { //알파벳 다 고른 경우
            int numVowel=0, numConsonant=0; //모음, 자음 개수

            for(int i=1; i<=L; i++) {
                if(isVowel(alp[selected[i]])) {
                    numVowel++;
                }
                else {
                    numConsonant++;
                }
            }

            if(numVowel>=1 && numConsonant>=2) {
                for(int i=1; i<=L; i++) {
                    sb.append(alp[selected[i]]); //출력
                }
                sb.append('\n');
            }
        }
        else {
            //알파벳들을 골라야 함 -> 일단 막 고르기
            for(int i=selected[k-1]+1; i<=C; i++) { //직전 알파벳 직후부터 시작
                selected[k] = i;

                func(k+1);
            }
        }

    }


    //모음이면 true
    static boolean isVowel(char c) {
        if(c=='a' || c=='e' || c=='i'|| c=='o'|| c=='u') {
            return true;
        }

        return false;
    }
    


    public static void main(String args[]) {
        input();

        Arrays.sort(alp, 1, C+1);
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
            while(st == null || !st.hasMoreElements()) {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }

}