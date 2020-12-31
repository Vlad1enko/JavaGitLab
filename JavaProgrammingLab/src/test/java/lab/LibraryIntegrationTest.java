package lab;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LibraryIntegrationTest {

    //Library mockLibrary = mock(Library.class);
    final Library library = new Library("Test Library");
    final Library spyLibrary = spy(library);
    final Author author1 = new Author("Test", "Test", "1985/6/23");
    final ArrayList<Book> bookList = new ArrayList<>();

    @Test
    public void shouldAddOneBookToLibrary() {
        //GIVEN
        Book testBook = new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS);
        //when(mockLibrary.getCapacity()).thenReturn(1);

        //WHEN
        spyLibrary.addBook(testBook);

        //THEN
        verify(spyLibrary).addBook(testBook);
        assertEquals(1,spyLibrary.getCapacity());
    }

    @Test
    public void shouldAddBookListToLibrary() {
        //GIVEN
        //if we use mock object, we can't get real size and constructor
        //when(mockLibrary.addOneMoreBook(ArgumentMatchers.<ArrayList<Book>>any())).thenCallRealMethod();
        //when(mockLibrary.getCapacity()).thenReturn(2);

        //WHEN
        bookList.add(new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS));
        bookList.add(new Book(author1, "Test2", 2012, "Test2", 9.99, BookGenreEnum.BUSINESS));
        spyLibrary.addOneMoreBook(bookList);

        //THEN
        verify(spyLibrary).addOneMoreBook(bookList);
        assertEquals(2,spyLibrary.getCapacity());
    }

    @Test
    public void shouldDeleteBook() {
        //GIVEN

        //WHEN
        bookList.add(new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS));
        spyLibrary.addOneMoreBook(bookList);
        spyLibrary.deleteBook(0);

        //THEN
        verify(spyLibrary).addOneMoreBook(bookList);
        verify(spyLibrary).deleteBook(anyInt());
        assertEquals(0, spyLibrary.getCapacity());
    }

    @Test
    public void isEqualBooks() {
        //GIVEN
        Book book1 = new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS);
        Book book2 = new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS);
        bookList.add(book1);
        bookList.add(book1);  //repeat

        //WHEN
        try {
            spyLibrary.addOneMoreBook(bookList);
            fail("Expected BooksEqualException for addBook method");
        } catch (Library.BooksEqualException e) {
            e.printStackTrace();
        }

        //THEN
        verify(spyLibrary).addOneMoreBook(bookList);
        assertEquals(1, spyLibrary.getCapacity());
        assertTrue(spyLibrary.isEqualBooks(book1));   //sNum is equal
        assertFalse(spyLibrary.isEqualBooks(book2));   //sNum is different
    }

}