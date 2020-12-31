package lab;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Author author1 = new Author("Hal", "Elrod", "1985/6/23");
        Author author2 = new Author("Stephen", "King", "1964/3/15");
        ArrayList<Book> bookList = new ArrayList<>();
        Book sampleBook = new Book(author2, "It", 1986, "Viking Press", 12.50, BookGenreEnum.HORROR);
        bookList.add(new Book(author1, "The Miracle Morning", 2012, "Unknown", 9.99, BookGenreEnum.BUSINESS));
        bookList.add(sampleBook);
        bookList.add(new Book(author2, "The green mile", 1996, "Subterranean Press", 16.50, BookGenreEnum.FANTASY));
        bookList.add(new Book(author1, "The Game of Thrones", 2005, "Subterranean Press", 42.50, BookGenreEnum.FANTASY));
        bookList.add(new Book(author2, "The Miracle", 1968, "London Press", 10.00, BookGenreEnum.FANTASY));
        Library library = new Library("British Library", bookList);

        logger.info(library.findBookInLibrary(sampleBook.getTitle()));
        logger.info(library.calculateTotalCost());

        library.findTheMostExpensiveBook().ifPresent(logger::info);

        logger.info(library.calculateAverageCostOfBooks());

        library.searchBookByGenre(BookGenreEnum.BUSINESS).forEach((key, value) -> logger.info(key + ":" + value) );

        logger.info(library.searchTheMostPopularGenre());

    }
}
