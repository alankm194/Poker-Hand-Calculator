package org.alan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandRankTest {
    @Test
    void testGetRank() {
        assertEquals(6, HandRank.FULL_HOUSE.getRank());
    }

}
