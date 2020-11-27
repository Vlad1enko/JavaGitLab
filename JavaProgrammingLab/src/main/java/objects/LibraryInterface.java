package objects;


import java.util.ArrayList;

public interface LibraryInterface {

    boolean addBook(Book book_new);

    public boolean addOneMoreBook(ArrayList<Book> bookList_new);

    boolean deleteBook(int index);

    boolean isEqualBooks(Book book_new);

    ArrayList<Book> getBookList();

    int getCapacity();

    String toString();

}
