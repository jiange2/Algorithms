package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification

class P20ValidParenthesesTest extends Specification {

    @Shared
    public P20ValidParentheses p = new P20ValidParentheses()

    def "IsValid"() {
        expect:
        p.isValid(str) == expect

        where:
        str      || expect
        "()"     || true
        "()[]{}" || true
        "(]"     || false
        "([)]"   || false
        "{[]}"   || true
    }
}
