package lab;

public class Book {

    private static int serialNumberGenerator = 0;
    private final int serialNumber;
    private final Author author;
    private final String title;
    private final int year;
    private final String publisher;
    private final double cost;
    private final BookGenreEnum genre;

    public Book() {
        this.serialNumber = serialNumberGenerator++;
        this.author = new Author();
        this.author.incrementNumOfBooks();
        this.title = "Title";
        this.year = 1970;
        this.publisher = "Unknown";
        this.cost = 4.99;
        this.genre = BookGenreEnum.CLASSICS;
    }

    public Book( Author authorNew, String titleNew, int yearNew, String publisherNew, double costNew, BookGenreEnum genre) {
        this.serialNumber = serialNumberGenerator++;
        this.author = authorNew;
        this.author.incrementNumOfBooks();  //located in this library
        this.title = titleNew;
        this.year = yearNew;
        this.publisher = publisherNew;
        this.cost = costNew;
        this.genre = genre;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public Author getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public double getCost() {
        return this.cost;
    }

    public BookGenreEnum getGenre() {
        return this.genre;
    }

    @Override
    public String toString() {
        StringBuilder strBuffer = new StringBuilder(genre.toString()); //smart memory allocation
        strBuffer.append(" book: \"");
        strBuffer.append(this.title);
        strBuffer.append("\" of ");
        strBuffer.append(this.author);
        strBuffer.append(" was published in ");
        strBuffer.append(this.year);
        strBuffer.append(".");
        strBuffer.append(" sNum: ");
        strBuffer.append(this.serialNumber);
        return strBuffer.toString();
    }

}
