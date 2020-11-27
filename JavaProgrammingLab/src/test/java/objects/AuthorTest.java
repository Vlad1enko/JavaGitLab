package objects;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthorTest {

    Author author1 = new Author("Test", "Test", "1985/6/23");
    Author author2 = new Author();
    Author author3 = new Author("Test","Test");

    @Test
    public void testGetters() {
        //GIVEN

        //WHEN

        //THEN
        assertEquals("Test", author1.getName());
        assertEquals("Test", author1.getSurname());
        assertEquals("1985/06/23", author1.getDobString());
        assertNotNull(author1.getDob());
    }

    @Test
    public void testToString() {
        //GIVEN
        String res = "Test Test";

        //WHEN

        //THEN
        assertEquals(res, author1.toString());
    }

    @Test
    public void testIncrementNumOfBooks() {
        //GIVEN

        //WHEN
        author1.incrementNumOfBooks();

        //THEN
        assertEquals(1, author1.getNumberOfBooks());
    }

    @Test
    public void testEquals() {
        //GIVEN

        //WHEN

        //THEN
        assertFalse(author1.equals(author2));
        assertTrue(author1.equals(author1));
        assertFalse(author1.equals(null));

    }
}