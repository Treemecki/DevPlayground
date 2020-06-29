package dev.treemecki.test.java.functional;

import dev.treemecki.java.functional.recursion.DataRepeater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class RecursionTests {

    @Test
    public void DataRepeaterTest() {
        final int iterations = 2000;
        final String repeaterData = new DataRepeater().create("abc", iterations);
        final String dataToCompare = String.join("", Collections.nCopies(iterations, "abc"));
        Assertions.assertTrue(repeaterData.equals(dataToCompare));
    }

}
