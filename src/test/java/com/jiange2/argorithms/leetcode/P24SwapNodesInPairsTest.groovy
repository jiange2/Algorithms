package com.jiange2.argorithms.leetcode

import com.jiange2.struct.ListNode
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class P24SwapNodesInPairsTest extends Specification {

    @Shared
    public P24SwapNodesInPairs p = new P24SwapNodesInPairs()

    public void "should return #expectList given #list when call swapPairs"() {

        expect:
        p.swapPairs(new ListNode(list)) == new ListNode(expectList)

        where:
        list            || expectList
        []              || []
        [1]             || [1]
        [1, 2]          || [2, 1]
        [1, 2, 3]       || [2, 1, 3]
        [1, 2, 3, 4]    || [2, 1, 4, 3]
        [1, 2, 3, 4, 5] || [2, 1, 4, 3, 5]
    }
}
