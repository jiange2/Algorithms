package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification

class P30SubstringwithConcatenationofAllWordsTest extends Specification {

    @Shared
    public P30SubstringwithConcatenationofAllWords p = new P30SubstringwithConcatenationofAllWords()

    def "FindSubstring"() {

        expect:
        p.findSubstring(str, words as String[]) == expect

        where:
        str | words || expect
        "barfoothefoobarman"       | ["foo", "bar"]                   || [0, 9]

        "barfoofoobarthefoobarman" | ["bar", "foo", "the"] || [6, 9, 12]
        "foobarfoobar"             | ["foo", "bar"]        || [0, 3, 6]
        "aaa" | ["a", "a"] || [0, 1]
        "abababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
        "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "babababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababab" +
                "abababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                "bababababababababababababababababababababab" | ["ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
                                                                 "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
                                                                 "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
                                                                 "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
                                                                 "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
                                                                 "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
                                                                 "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
                                                                 "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
                                                                 "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
                                                                 "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
                                                                 "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
                                                                 "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba",
                                                                 "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab",
                                                                 "ba", "ab", "ba", "ab", "ba"] || []

    }
}
