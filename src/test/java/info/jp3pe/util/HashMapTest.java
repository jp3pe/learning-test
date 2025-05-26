package info.jp3pe.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    private static final String NAME = "name";
    private static final String AGE = "age";
    private Map<String, StringBuilder> testObject;

    @BeforeEach
    void setUp() {
        testObject = new HashMap<>();

        testObject.put(NAME, new StringBuilder("JaeKwang Kim"));
        testObject.put(AGE, new StringBuilder("26 years old"));
    }

    @Test
    void clear_return0KeysAndValues() {
        Map<String, StringBuilder> expected = new HashMap<>();

        testObject.clear();

        assertTrue(testObject.isEmpty());
        assertEquals(0, testObject.size());
        assertNull(testObject.get(NAME));
        assertNull(testObject.get(AGE));
        assertEquals(expected, testObject);
    }
}
