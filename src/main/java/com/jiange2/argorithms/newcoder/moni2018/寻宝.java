package com.jiange2.argorithms.newcoder.moni2018;

import java.util.*;

public class 寻宝 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer,List<QK>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<M || sc.hasNext(); ++i){
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int K = sc.nextInt();
            List<QK> list = map.computeIfAbsent(P, k -> new ArrayList<>());
            list.add(new QK(Q,K));
            System.out.println(P + " " + Q + " " + K + " " + i);
        }

        int[] dp = new int[N];
        while(N > 0){
            set.add(N--);
        }

        System.out.println(getLongestWood(map,set,dp,1,0));
    }

    public static int getLongestWood(Map<Integer,List<QK>> map,Set<Integer> set,int[] dp,int now,int last){
        List<QK> list = map.get(now);
        if(set.isEmpty() || list == null){
            return last;
        }

        int least = Integer.MAX_VALUE;
        for(QK qK : list){
            if(set.contains(qK.Q)){
                set.remove(qK.Q);
                int t = dp[qK.Q] != 0 ? dp[qK.Q] : getLongestWood(map,set,dp,qK.Q,qK.K);
                dp[qK.Q] = t;
                least = Math.min(least,t);
                set.add(qK.Q);
            }
        }

        return Math.max(least,last);
    }

    static class QK{
        int Q;
        int K;

        public QK(int Q, int K){
            this.Q = Q;
            this.K = K;
        }
    }
}
