package objects;

public class Book {

    private static int serialNumberGenerator = 0;
    private int serialNumber;
    private final Author author;
    private final String title;
    private final int year;
    private String publisher;
    private double cost;
    private BookGenreEnum genre;

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

    public Book( Author author_new, String title_new, int year_new, String publisher_new, double cost_new, BookGenreEnum genre) {
        this.serialNumber = serialNumberGenerator++;
        this.author = author_new;
        this.author.incrementNumOfBooks();  //located in this library
        this.title = title_new;
        this.year = year_new;
        this.publisher = publisher_new;
        this.cost = cost_new;
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
    public String toString() { // TODO change to toString
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

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if (obj == null || obj.getClass() != this.getClass()) {
//            return false;
//        }
//
//        Book guest = (Book) obj;
//        return serialNumber == guest.serialNumber;
//    }
}
