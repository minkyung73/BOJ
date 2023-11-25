package test.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Gift>> list = new ArrayList<>();
        ArrayList<HashMap<String, Integer>> map = new ArrayList<>();

        list.add(new ArrayList<>());
        list.get(0).add(new Gift("muzi", 0));

        list.get(0).set(0, new Gift("muzi", 1));

        ArrayList<Give_Take> list2 = new ArrayList<>();
        list2.add(new Give_Take("muzi", 0, 0, 0));
        list2.set(0, new Give_Take("muzi", 0, 0, 1));
    }
    public static class Gift {
        String name;
        int score;

        public Gift(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static class Give_Take {
        String name;
        int give, take, score;

        public Give_Take(String name, int give, int take, int score) {
            this.name = name;
            this.give = give;
            this.take = take;
            this.score = score;
        }
    }
}
