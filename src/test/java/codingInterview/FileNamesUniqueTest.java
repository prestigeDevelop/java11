package codingInterview;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileNamesUniqueTest {
    private FileNamesUnique fileNamesUnique;

    @org.junit.jupiter.api.Test
    void test() {

        assertArrayEquals(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"},
                FileNamesUnique.unique(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"}));
    }

    @org.junit.jupiter.api.Test
    void test2() {

        assertNotNull(
                FileNamesUnique.unique(new String[]{"onepiecee", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"}));
    }
}