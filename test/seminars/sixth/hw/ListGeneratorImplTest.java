package seminars.sixth.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListGeneratorImplTest {
    private final int MAX_LIST_VALUE = 100;
    private final int LIST_SIZE = 10;

    @BeforeEach
    void setUp() {
    }

    @Test
    void dataGenerateSizeCheck() {
        ListGenerator listGenerator = new ListGeneratorImpl();
        List<Integer> list = listGenerator.dataGenerate(LIST_SIZE, MAX_LIST_VALUE);
        assertEquals(LIST_SIZE, list.size());
    }

    @Test
    void dataGenerateLessThanMax() {
        ListGenerator listGenerator = new ListGeneratorImpl();
        List<Integer> list = listGenerator.dataGenerate(LIST_SIZE, MAX_LIST_VALUE);
        assertTrue(MAX_LIST_VALUE >= Collections.max(list));
    }
}