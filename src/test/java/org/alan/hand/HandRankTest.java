package org.alan.hand;

import org.alan.HandRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class HandRankTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/handRankTest.csv", numLinesToSkip = 1)
    void testGetRank(String hand, int expectedRank) {
        Assertions.assertEquals(expectedRank, HandRank.valueOf(hand).getRank());
    }

}
