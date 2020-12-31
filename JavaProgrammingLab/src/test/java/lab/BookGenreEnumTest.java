package lab;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BookGenreEnumTest {

    final BookGenreEnum testEnum = BookGenreEnum.BUSINESS;

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() { BookGenreEnum.valueOf("History").toString(); }

    @Test
    public void testToString() {
        //GIVEN
        String[] enumStr = {"Adventure", "Classics", "Fantasy", "Horror", "Sci-fi", "Business"};

        //WHEN

        //THEN
        for (int i = 0; i < enumStr.length; i++) {
            assertEquals(enumStr[i], Arrays.asList(BookGenreEnum.values()).get(i).toString());
        }
    }

    @Test
    public void isFiction() {
        //GIVEN

        //WHEN

        //THEN
        assertFalse(testEnum.isFiction());
    }
}