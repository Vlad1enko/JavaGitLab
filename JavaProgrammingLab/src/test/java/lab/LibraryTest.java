package lab;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    final Library library = new Library("Test Library");
    final Author author1 = new Author("Test", "Test", "1985/6/23");
    final ArrayList<Book> bookList = new ArrayList<>();
    final Book book1 = new Book(author1, "Test", 2012, "Test", 9.99, BookGenreEnum.BUSINESS);


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

    @Test
    public void testIsEqualBooks() {
        //GIVEN
        library.addBook(book1);

        //WHEN
        library.addBook(book1);

        //THEN
        assertEquals(1, library.getCapacity());
        assertEquals(book1, library.getBookList().get(0));
    }

    @Test(expected = Library.BooksEqualException.class)
    public void testIsEqualBooksException() {
        //GIVEN
        library.addBook(book1);

        //WHEN
        library.addBook(book1);


        //THEN
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

//    @Test
//    public void testFindBookInLibrary() {
//        //GIVEN
//        bookList.add(book1);
//
//        //WHEN
//        Library lib = new Library("libraryConstructorTest", bookList);
//
//        //THEN
//        assertEquals(book1, lib.findBookInLibrary(book1.getTitle()));
//    }
    @Test
    public void testCalculateTotalCost() {
        //GIVEN
        bookList.add(book1);
        bookList.add(new Book(author1, "The Miracle", 1968, "London Press", 10.00, BookGenreEnum.FANTASY));

        //WHEN
        Library lib = new Library("libraryConstructorTest", bookList);

        //THEN
        assertEquals(19.99,Math.floor(lib.calculateTotalCost()*100)/100 );
    }
    @Test
    public void testFindTheMostExpensiveBook() {
        //GIVEN
        bookList.add(book1);
        bookList.add(new Book(author1, "The Miracle", 1968, "London Press", 5.00, BookGenreEnum.FANTASY));

        //WHEN
        Library lib = new Library("libraryConstructorTest", bookList);
        Optional<Book> res = Optional.of(book1);

        //THEN
        assertTrue(lib.findTheMostExpensiveBook().isPresent());
        assertEquals(res, lib.findTheMostExpensiveBook());
    }

    @Test
    public void testCalculateAverageCostOfBooks() {
        //GIVEN
        bookList.add(book1);
        bookList.add(new Book(author1, "The Miracle", 1968, "London Press", 5.00, BookGenreEnum.FANTASY));

        //WHEN
        Library lib = new Library("libraryConstructorTest", bookList);

        //THEN
        assertEquals((9.99+5.00)/2, lib.calculateAverageCostOfBooks() );
    }

//    @Test
//    public void testSearchBookByGenre() {
//        //GIVEN
//        bookList.add(book1);
//        bookList.add(new Book(author1, "The Miracle", 1968, "London Press", 5.00, BookGenreEnum.FANTASY));
//
//        //WHEN
//        Library lib = new Library("libraryConstructorTest", bookList);
//        List<Book> resTrue = new ArrayList<>();
//
//
//        //THEN
//        assertEquals( new Book(author1, "The Miracle", 1968, "London Press", 5.00, BookGenreEnum.FANTASY), lib.searchBookByGenre(BookGenreEnum.FANTASY).get(true).get(0) );
//        assertEquals( book1, lib.searchBookByGenre(BookGenreEnum.FANTASY).get(true).get(0) );
//    }
}