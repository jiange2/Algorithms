package com.jiange2.argorithms.leetcode

import com.jiange2.struct.ListNode
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class P82RemoveDuplicatesfromSortedListIITest extends Specification {

    @Shared
    public P82RemoveDuplicatesfromSortedListII p = new P82RemoveDuplicatesfromSortedListII()

    def "should return #output when input #input"() {

        expect:
        p.deleteDuplicates(new ListNode(input)) == new ListNode(output)

        where:
        input              || output
        null               || null
        [1]                || [1]
        [1, 2]             || [1, 2]
        [1, 2, 2]          || [1]
        [1, 2, 2, 3, 3, 3] || [1]
        [1, 1, 2]          || [2]
        [1, 1, 2, 2]       || []
    }
}
