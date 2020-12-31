package lab;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

public class BookIntegrationTest {

    final Author author1 = new Author("Test", "Test", "1985/6/23");
    final Book testBook = new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS);
    final Book spyBook = spy(testBook);


    @Test
    public void getterShouldReturnCorrectAuthor() {
        assertEquals(author1,spyBook.getAuthor());
        assertEquals(author1, spyBook.getAuthor());
    }

    @Test
    public void getterShouldReturnCorrectGenre() {
        assertEquals(BookGenreEnum.BUSINESS,spyBook.getGenre());
    }
}