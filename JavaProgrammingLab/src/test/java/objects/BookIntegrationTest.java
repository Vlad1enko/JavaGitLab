package objects;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

public class BookIntegrationTest {

    Author author1 = new Author("Test", "Test", "1985/6/23");
    Book testBook = new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS);
    Book spyBook = spy(testBook);


    @Test
    public void getterShouldReturnCorrectAuthor() {
        assertEquals(author1,spyBook.getAuthor());
        assertTrue(spyBook.getAuthor().equals(author1));
    }

    @Test
    public void getterShouldReturnCorrectGenre() {
        assertEquals(BookGenreEnum.BUSINESS,spyBook.getGenre());
    }
}