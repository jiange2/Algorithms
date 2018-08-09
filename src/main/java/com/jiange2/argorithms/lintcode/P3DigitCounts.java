package com.jiange2.argorithms.lintcode;

import org.junit.Test;

/**
 * Count the number of k's between 0 and n. k can be 0 - 9.
 */
public class P3DigitCounts {

    @Test
    public void test() {
        System.out.println(digitCounts(1, 12));
    }

    public int digitCounts(int k, int n) {

        if (k == 0 && n == 0) {
            return 1;
        }

        int count = 0,zeros = 1,quotient,t = n / 10;

        while (zeros <= t) {
            quotient = n / zeros;
            count += quotient / 10 * zeros;
            if (quotient % 10 > k) {
                count += zeros;
            } else if (quotient % 10 == k) {
                count += n % zeros + 1;
            }
            zeros *= 10;
            //System.out.println(count);
        }

        quotient = n / zeros;
        if (k != 0) {
            if (quotient > k) {
                count += zeros;
            } else if (quotient == k) {
                count += n % zeros + 1;
            }
        }

        //System.out.println(count);

        return count;
    }


}
