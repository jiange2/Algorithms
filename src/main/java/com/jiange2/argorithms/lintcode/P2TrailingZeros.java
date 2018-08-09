package com.jiange2.argorithms.lintcode;

import org.junit.Test;

public class P2TrailingZeros {

    /**
     * 每次乘5^k，增加k个0
     * @param n 阶乘数
     * @return 尾部0的数目
     */
    public long trailingZeros(long n) {
        long count = 0;
        while (n >= 5) {
            //n含有最大的k (5^k的k)
            int deg = (int) (Math.log(n) / Math.log(5));
            //5^k 当前最大乘到的5^k
            long l1 = (long) Math.pow(5, deg);
            //当前n包含了 l2 个 5^k
            int l2 = (int) (n/l1);
            //统计0-5^k 含 5 的个数 (25含2个5 125含3个5)
            //统计5^k中5,5^1,5^2,...,5^k的倍数个数的和
            //5^0 (5^k的次数) + 5^1 (5^k的次数)+ 5^2 (5^k的次数)+ ... + 5^(k-1)(5的次数)
            //举例: 对于0-125来说 125倍数的个数为1(5^0) (125) , 25倍数的个数为5(5^1) (25,50,75,100,125),
            //5倍数的个数为25 (5^2) (5,10,15,...,125)
            //这种统计方式让5^k被统计k次,所以结果就是 0-5^k含5的个数
            //所以这里是等比数列的和  1 - q^k  / 1 - q, q = 5
            long d1 = (long) ((l1 - 1) / 4.0);
            count +=  l2 * d1;
            n %= l2 * l1;
        }

        return  count;
    }

    int numOfZero(int n)
    {
        int num = 0;
        for(long i=5; i<=n; i*=5)
        {
            num += n/i;
        }
        return num;
    }

    @Test
    public void test(){
        System.out.println(trailingZeros(30));
    }
}
