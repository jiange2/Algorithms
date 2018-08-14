package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification

class P22GenerateParenthesesTest extends Specification {

    @Shared
    public P22GenerateParentheses p = new P22GenerateParentheses()

    def "GenerateParenthesis"() {
        expect:
        p.generateParenthesis(count) == expect

        where:
        count || expect
        -1    || []
        0     || []
        1     || ["()"]
        2     || ["(())","()()"]
        3     || ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}
