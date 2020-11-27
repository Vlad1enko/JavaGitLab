package objects;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LibraryTest {

    Library library = new Library("Test Library");
    Author author1 = new Author("Test", "Test", "1985/6/23");
    ArrayList<Book> bookList = new ArrayList<>();
    Book book1 = new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS);


    @Test
    public void testConstructor() {
        //GIVEN
        bookList.add(new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS));
        bookList.add(new Book(author1, "Test2", 2012, "Test2", 9.99, BookGenreEnum.BUSINESS));

        //WHEN
        Library libraryConstructorTest = new Library("libraryConstructorTest", bookList);

        //THEN
        assertEquals(2, libraryConstructorTest.getCapacity());
    }

    @Test
    public void testAddBook() {
        //GIVEN

        //WHEN
        library.addBook(book1);

        //THEN
        assertEquals(1, library.getCapacity());
        assertEquals(book1, library.getBookList().get(0));
    }

    @Test(expected = Library.BooksEqualException.class) //EXCEPTION
    public void testBookEqualException() {
        library.addBook(book1);
        library.addBook(book1);
    }

    @Test
    public void testAddOneMoreBook() {
        //GIVEN
        bookList.add(book1);
        bookList.add(new Book(author1, "Test2", 2012, "Test2", 9.99, BookGenreEnum.BUSINESS));

        //WHEN
        library.addOneMoreBook(bookList);

        //THEN
        assertEquals(2, library.getCapacity());
        assertEquals(bookList, library.getBookList());
    }

    @Test
    public void testDeleteBook() {
        //GIVEN
        bookList.add(new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS));
        bookList.add(new Book(author1, "Test2", 2012, "Test2", 9.99, BookGenreEnum.ADVENTURE));
        library.addOneMoreBook(bookList);

        //WHEN
        library.deleteBook(library.getCapacity()-1);

        //THEN
        assertEquals(1, library.getCapacity());
        assertEquals(bookList.get(0), library.getBookList().get(0));
    }

    @Test
    public void testDeleteBookFromEmptyLibrary() {
        //GIVEN

        //WHEN

        //THEN
        assertFalse(library.deleteBook(0));
    }

    @Test(expected = Library.BooksEqualException.class)
    public void testIsEqualBooks() {
        //GIVEN
        library.addBook(book1);

        //WHEN
        library.addBook(book1);

        //THEN
        assertEquals(1, library.getCapacity());
        assertEquals(book1, library.getBookList().get(0));
    }

    @Test
    public void testGetBookList() {
        //GIVEN
        bookList.add(new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS));
        bookList.add(new Book(author1, "Test2", 2012, "Test2", 9.99, BookGenreEnum.ADVENTURE));

        //WHEN
        library.addOneMoreBook(bookList);

        //THEN
        assertEquals(bookList, library.getBookList());
    }

    @Test
    public void testGetCapacity() {
        //GIVEN
        bookList.add(new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS));
        bookList.add(new Book(author1, "Test2", 2012, "Test2", 9.99, BookGenreEnum.ADVENTURE));

        //WHEN
        library.addOneMoreBook(bookList);

        //THEN
        assertEquals(2, library.getCapacity());
    }

    @Test
    public void testToString() {
        //GIVEN
        String res = "Library: \"Test Library\"\n";

        //WHEN

        //THEN
        assertEquals(res, library.toString());
    }
}