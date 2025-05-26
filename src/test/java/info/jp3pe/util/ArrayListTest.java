package info.jp3pe.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private static final String nameToAdd = "Dog";
    private static final List<String> namesToAdd = Arrays.asList("Dog", "Elephant");
    private ArrayList<String> names;

    @BeforeEach
    void setUp() {
        names = new ArrayList<>();
        names.addAll(Arrays.asList("Ant", "Bee", "Cat"));
    }

    @Test
    void add_returnTrue_whenGivenElementAppendedAtTheEnd() {
        List<String> expected = new ArrayList<>(Arrays.asList("Ant", "Bee", "Cat", nameToAdd));

        boolean result = names.add(nameToAdd);

        assertTrue(result);
        assertIterableEquals(expected, names);
    }

    @Test
    void add_nullInsertedBetweenElements_whenGivenElementIsNull() {
        List<String> expected = new ArrayList<>(Arrays.asList("Ant", "Bee", "Cat", null, nameToAdd));

        names.add(null);
        names.add(nameToAdd);

        assertIterableEquals(expected, names);
    }

    @Test
    void add_elementAddedAtTheIndex() {
        List<String> expected = new ArrayList<>(Arrays.asList("Ant", "Bee", "Dog", "Cat"));

        names.add(2, nameToAdd);

        assertIterableEquals(expected, names);
    }

    @Test
    void add_throwIndexOutOfBoundsException_whenGivenIndexIsSmallerThan0() {
        assertThrows(IndexOutOfBoundsException.class, () -> names.add(-1, nameToAdd));
    }

    @Test
    void add_throwIndexOutOfBoundsException_whenGivenIndexIsBiggerThanThisArrayListSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> names.add(10, nameToAdd));
    }

    @Test
    void addAll_returnTrue_whenGivenCollectionAppendedAtTheEnd() {
        List<String> expected = new ArrayList<>(Arrays.asList("Ant", "Bee", "Cat", "Dog", "Elephant"));

        boolean result = names.addAll(namesToAdd);

        assertTrue(result);
        assertIterableEquals(expected, names);
    }

    @Test
    void addAll_throwNullPointerException_whenGivenElementIsNull() {
        assertThrows(NullPointerException.class, () -> names.addAll(null));
    }

    @Test
    void addAll_addGivenCollationAtTheIndex() {
        List<String> expected = new ArrayList<>(Arrays.asList("Ant", "Bee", "Dog", "Elephant", "Cat"));

        boolean result = names.addAll(2, namesToAdd);

        assertTrue(result);
        assertIterableEquals(expected, names);
    }

    @Test
    void addAll_throwIndexOutOfBoundsException_whenGivenIndexIsSmallerThan0() {
        assertThrows(IndexOutOfBoundsException.class, () -> names.addAll(-1, namesToAdd));
    }

    @Test
    void addAll_throwIndexOutOfBoundsException_whenGivenIndexIsBiggerThanThisArrayListSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> names.addAll(4, namesToAdd));
    }

    @Test
    void addAll_throwNullPointerException_whenGivenCollectionIsNull() {
        assertThrows(NullPointerException.class, () -> names.addAll(2, null));
    }

    @Test
    void clear_returnEmptyList() {
        List<String> expected = new ArrayList<>();

        names.clear();

        assertIterableEquals(expected, names);
        assertEquals(0, names.size());
    }

    @Test
    void contains_returnTrue_whenGivenObjectIsExistIn() {
        String toFind = "Cat";

        boolean result = names.contains(toFind);

        assertTrue(result);
    }

    @Test
    void contains_returnFalse_whenGivenObjectIsNotExist() {
        String toFind = "Dog";

        boolean result = names.contains(toFind);

        assertFalse(result);
    }

    @Test
    void contains_returnFalse_whenGivenObjectIsNull() {
        String toFind = null;

        boolean result = names.contains(toFind);

        assertFalse(result);
    }

    @Test
    void get_returnNthElement_whenGivenIndexIsNotOutOfBounds() {
        String expect = "Cat";

        String actual = names.get(2);

        assertEquals(expect, actual);
    }

    @Test
    void get_throwIndexOutOfBoundsException_whenGivenIndexIsSmallerThan0() {
        assertThrows(IndexOutOfBoundsException.class, () -> names.get(-1));
    }

    @Test
    void get_throwIndexOutOfBoundsException_whenGivenIndexIsAsSameAsSizeOrBigger() {
        assertThrows(IndexOutOfBoundsException.class, () -> names.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> names.get(10));
    }

    @Test
    void indexOf_returnIndex_whenGivenObjectExist() {
        String toFind = "Cat";

        int index = names.indexOf(toFind);

        assertEquals(2, index);
    }

    @Test
    void indexOf_returnMinus1_whenGivenObjectIsExist() {
        String toFind = "Dog";

        int index = names.indexOf(toFind);

        assertEquals(-1, index);
    }

    @Test
    void isEmpty_returnTrue_whenArrayListHasNoElement() {
        List<String> emptyNames = new ArrayList<>();

        boolean result = emptyNames.isEmpty();

        assertTrue(result);
    }

    @Test
    void isEmpty_returnFalse_whenArrayListHasElement() {
        boolean result = names.isEmpty();

        assertFalse(result);
    }

    @Test
    void isEmpty_returnFalse_whenArrayListHasNullElement() {
        List<String> nullNames = new ArrayList<>();
        nullNames.add(null);

        boolean result = nullNames.isEmpty();

        assertFalse(result);
    }

    @Test
    void iterator_returnIteratorType() {
        assertInstanceOf(Iterator.class, names.iterator());
    }
}
