
import objects.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Author author1 = new Author("Hal", "Elrod", "1985/6/23");
        Author author2 = new Author("Stephen", "King", "1964/3/15");
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book(author1, "The Miracle Morning", 2012, "Unknown", 9.99, BookGenreEnum.BUSINESS));
        bookList.add(new Book(author2, "It", 1986, "Viking Press", 12.50, BookGenreEnum.HORROR));
        bookList.add(new Book(author2, "The green mile", 1996, "Subterranean Press", 16.50, BookGenreEnum.FANTASY));
        Library library = new Library("British Library", bookList);
        System.out.println(library.toString());

        //SHOW WORK EXAMPLES

        Book testBook = new Book();
        library.addBook(testBook);
        System.out.println(library.toString()); //adding book

        library.addBook(testBook);
        System.out.println(library.toString());  //adding existing book fails

        library.deleteBook(library.getCapacity()-1); //deleting book
        System.out.println(library.toString());

        //POLYMORPHISM
        LibraryInterface p = new Library("Polymorphic library");
        System.out.println(p.toString());
        p.addOneMoreBook(bookList);  //multiple add
        System.out.println(p.toString());

        System.out.println( author1.getDobString()); //show dob

        System.out.println("Comparing 2 books: " + bookList.get(1).equals(bookList.get(2)));
        Author authorTest = new Author("Stephen", "King", "1964/3/15");
        System.out.println("Comparing 2 authors: " + author2.equals(authorTest));

        System.out.println("Is \"" + bookList.get(0).getTitle() + "\" fiction literature?: " + bookList.get(0).getGenre().isFiction() );
        System.out.println("Is \"" + bookList.get(2).getTitle() + "\" fiction literature?: " + bookList.get(2).getGenre().isFiction() );

        //TESTING
    }
}
