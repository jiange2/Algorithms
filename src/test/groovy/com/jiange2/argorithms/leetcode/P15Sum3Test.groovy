package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class P15Sum3Test extends Specification {

    @Shared
    public P15Sum3 p = new P15Sum3();

    def "ThreeSum( #arr ) == #output"() {
        expect:
        p.threeSum(arr as int[]) == output

        where:
        arr                   || output
        [0, 0, 0, 0]          || [[0, 0, 0]]
        [-1, 0, 1, 2, -1, -4] || [[-1, -1, 2], [-1, 0, 1]]
    }
}
