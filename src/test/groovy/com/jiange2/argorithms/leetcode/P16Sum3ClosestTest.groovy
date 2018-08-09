package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification

class P16Sum3ClosestTest extends Specification {
    @Shared
    public P16Sum3Closest p = new P16Sum3Closest()

    def "ThreeSumClosest"() {
        expect:
        p.threeSumClosest(arr as int[], target) == output

        where:
        arr                            | target || output
        /*[-1, 2, 1, -4]                 | 1      || 2
        [0, 2, 1, -3]                  | 1      || 0
        [1, 2, 4, 8, 16, 32, 64, 128]  | 82     || 82*/
        /*[4, 0, 5, -5, 3, 3, 0, -4, -5] | -2     || -2*/
        [-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33] | 0 || 0
    }


}
