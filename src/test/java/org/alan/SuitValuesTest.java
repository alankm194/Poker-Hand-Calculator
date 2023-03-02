package org.alan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuitValuesTest {

    @Test
    void testGettingSuitValues() {
        assertEquals(1, SuitValues.DIAMOND.getValue());
    }

}
