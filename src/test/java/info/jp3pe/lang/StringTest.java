package info.jp3pe.lang;

import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    private final char[] charsForTest = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!'};
    private final Long longForTest = 10L;
    private final String stringForTest = "hello world!";

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

    @Test
    void valueOf_returnAStringRepresentOfTheLongArgument_whenGivenLong() {
        String lConverted = String.valueOf(longForTest);

        assertEquals("10", lConverted);
    }

    @Test
    void charAt_returnChar_whenIndexIsGiven() {
        assertEquals('e', stringForTest.charAt(1));
    }

    @Test
    void charAt_throwIndexOutOfBoundsException_whenGivenIndexIsNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringForTest.charAt(-1));
    }

    @Test
    void charAt_throwIndexOutOfBoundsException_whenGivenIndexIsNotLessThanTheLengthOfItsString() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringForTest.charAt(stringForTest.length()));
    }

    @Test
    void compareTo_return0_whenGivenStringIsLexicographicallySame() {
        int compareResult = stringForTest.compareTo(stringForTest);

        assertEquals(0, compareResult);
    }

    @Test
    void compareTo_returnGreaterThan0_whenGivenStringIsLexicographicallyLess() {
        String greaterString = "aello world!";

        int compareResult = stringForTest.compareTo(greaterString);

        assertTrue(compareResult > 0);
    }

    @Test
    void compareTo_returnLessThan0_whenGivenStringIsLexicographicallyGreater() {
        String lessString = "zello world!";

        int compareResult = stringForTest.compareTo(lessString);

        assertTrue(compareResult < 0);
    }

    @Test
    void concat_returnConcatenatedString_whenStringIsGiven() {
        String toConcat = "!!!";

        String concatenated = stringForTest.concat(toConcat);

        assertEquals(stringForTest + "!!!", concatenated);
    }

    @Test
    void contains_returnTrue_whenGivenStringIsContained() {
        String toFind = "hello";

        assertTrue(stringForTest.contains(toFind));
    }

    @Test
    void contains_returnFalse_whenGivenStringIsNotContained() {
        String toFind = "hola";

        assertFalse(stringForTest.contains(toFind));
    }

    @Test
    void endsWith_returnTrue_whenThisStringIsEndWithGivenString() {
        String toFind = "world!";

        assertTrue(stringForTest.endsWith(toFind));
    }

    @Test
    void endsWith_returnTrue_whenGivenStringIsTheEmptyString() {
        String toFind = "";

        assertTrue(stringForTest.endsWith(toFind));
    }

    @Test
    void endsWith_returnFalse_whenThisStringIsNotEndWithGivenString() {
        String toFind = "mundo!";

        assertFalse(stringForTest.endsWith(toFind));
    }

    @Test
    void indexOf_returnIndex_whenGivenStringIsExistInTheThisString() {
        String toFind = " ";

        int i = stringForTest.indexOf(toFind);

        assertEquals(5, i);
    }

    @Test
    void indexOf_returnMinus1_whenGivenStringIsNotExistInTheThisString() {
        String toFind = "@";

        int i = stringForTest.indexOf(toFind);

        assertEquals(-1, i);
    }

    @Test
    void isEmpty_returnTrue_whenThisStringsLengthIs0() {
        assertTrue("".isEmpty());
    }

    @Test
    void isEmpty_returnFalse_whenThisStringLengthIsNot0() {
        assertFalse(stringForTest.isEmpty());
    }

    @Test
    void replace_returnReplacedString_whenGivenStringToFindIsExistOnThisString() {
        String toReplaced = "hell";
        String toFind = "hello";

        String replacedString = stringForTest.replace(toFind, toReplaced);

        assertEquals("hell world!", replacedString);
    }

    @Test
    void replace_returnOriginalThisString_whenGivenStringToFindIsNotExistOnThisString() {
        String toReplaced = "hell";
        String toFind = "hola";

        String replacedString = stringForTest.replace(toFind, toReplaced);

        assertEquals(stringForTest, replacedString);
    }

    @Test
    void split_returnSplitStrings_whenGivenRegexIsExistInThisString() {
        String regex = " ";
        String[] expectedStrings = {"hello", "world!"};

        String[] splitStrings = stringForTest.split(regex);

        assertArrayEquals(expectedStrings, splitStrings);
    }

    @Test
    void split_returnOriginalString_whenGivenRegexIsNotExistInThisString() {
        String regex = ":";
        String[] expectedStrings = {"hello world!"};

        String[] splitStrings = stringForTest.split(regex);

        assertArrayEquals(expectedStrings, splitStrings);
    }

    @Test
    void split_throwPatternSyntaxException_whenGivenRegexIsNotValid() {
        String regex = "[abc";

        assertThrows(PatternSyntaxException.class, () -> stringForTest.split(regex));
    }

    @Test
    void trim_returnTrimmedString() {
        String spacedStringForTest = " " + stringForTest + " ";

        String trimmedTestString = spacedStringForTest.trim();

        assertEquals("hello world!", trimmedTestString);
    }
}
