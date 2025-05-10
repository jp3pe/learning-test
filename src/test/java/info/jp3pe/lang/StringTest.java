package info.jp3pe.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    private final char[] charsForTest = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!'};

    @Test
    void copyValueOf_returnString_whenGivenFullCharArray() {
        String s = String.copyValueOf(charsForTest);

        assertEquals("hello world!", s);
    }

    @Test
    void copyValueOf_returnSubarray_whenGivenFullCharArrayOffsetAndCount() {
        String s = String.copyValueOf(charsForTest, 6, 5);

        assertEquals("world", s);
    }

    @Test
    void copyValueOf_throwIndexOutOfBoundsException_whenGivenOffsetIsNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> String.copyValueOf(charsForTest, -1, 5));
    }

    @Test
    void copyValueOf_throwIndexOutOfBoundsException_whenGivenCountIsNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> String.copyValueOf(charsForTest, 6, -1));
    }

    @Test
    void copyValueOf_throwIndexOutOfBoundsException_whenGivenOffsetPlusCountIsLargetThanCharArray() {
        assertThrows(IndexOutOfBoundsException.class, () -> String.copyValueOf(charsForTest, 100, 100));
    }
}
