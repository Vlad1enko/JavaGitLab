package objects;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    Book book1 = new Book();

    @Test
    public void testGetters() {
        assertNotNull(book1.getAuthor());
        assertEquals(4.99, book1.getCost());
        assertEquals(BookGenreEnum.CLASSICS, book1.getGenre());
        assertEquals("Unknown", book1.getPublisher());
        assertEquals("Title", book1.getTitle());
        assertEquals(1970, book1.getYear());
    }
}