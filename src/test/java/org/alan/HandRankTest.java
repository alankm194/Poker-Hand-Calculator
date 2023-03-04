package org.alan;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandRankTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/handRankTest.csv", numLinesToSkip = 1)
    void testGetRank(String hand, int expectedRank) {
        assertEquals(expectedRank, HandRank.valueOf(hand).getRank());
    }

}
