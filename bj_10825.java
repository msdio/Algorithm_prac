import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Scores[] a;


    //입력받는 함수
    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //BufferedReader를 사용하기 위한 예외처리
        try {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            a = new Scores[N];

            for(int i=0; i<N; i++) {
                a[i] = new Scores();
                st = new StringTokenizer(br.readLine());
                a[i].name = st.nextToken();
                a[i].kor = Integer.parseInt(st.nextToken());
                a[i].eng = Integer.parseInt(st.nextToken());
                a[i].math = Integer.parseInt(st.nextToken());
            }


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    
    static class Scores implements Comparable<Scores> {
        public String name;
        public int kor, eng, math;

        /*
        Scores(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
         */

        @Override
        public int compareTo(Scores o) {
            //국어 점수는 내림차순으로
            if(kor != o.kor) {
                return (o.kor - kor);
            }
            //영어 점수는 오름차순
            if(eng != o.eng) {
                return (eng - o.eng);
            }
            //수학 점수는 내림차순
            if(math != o.math) {
                return (o.math - math);
            }
            //이름은 오름차순
            return name.compareTo(o.name);
        }
    }



    public static void main(String[] args) {
        input();

        Arrays.sort(a);

        //출력
        for(int i=0; i<a.length; i++) {
            sb.append(a[i].name);
            sb.append('\n');
        }


        System.out.println(sb.toString());
    }
}