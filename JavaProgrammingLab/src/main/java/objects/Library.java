package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Library implements LibraryInterface {

    private AtomicInteger capacity = new AtomicInteger(0); // TODO thread-safe counter
    private List<Book> bookList = new ArrayList<>();
    private String name;

    static class BooksEqualException extends RuntimeException {

        public BooksEqualException(String message){
            super(message);
        }

    }

    public Library(String name_new) {
        this.name = name_new;
    }

    public Library(String name_new, ArrayList<Book> bookList_new) {  //TODO remove 'capacity'
        this.name = name_new;
        this.capacity.set(bookList_new.size());
        if ( this.capacity.get() > 0) {
            if (bookList != null) {
                bookList.addAll(bookList_new);
            }
        }
    }

    public boolean addBook(Book book_new) {  //TODO add list argument
        if (!isEqualBooks(book_new)) { //add exception
            this.bookList.add(book_new);
            System.out.println("--Successfully added a book");
            this.capacity.incrementAndGet();
            return true;
        } else {
            throw new BooksEqualException("BooksEqualException with " + book_new.toString());
        }
    }

    public boolean addOneMoreBook(ArrayList<Book> bookList_new) {  //TODO add list argument
        boolean flag = true;
        for (Book book : bookList_new) {
            if (!this.addBook(book)) {
                flag = false;
            }
        }
        return flag;
    }

    public boolean deleteBook(int index) {    //add exception
        try {
            this.bookList.remove(index);
            System.out.println("--Successfully deleted a book");
            this.capacity.decrementAndGet();
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Delete item with index out of bounds. Exit.");
            return false;
        }
    }

    public boolean isEqualBooks(Book book_new) {
        return this.bookList.contains(book_new);
    }                               

    public ArrayList<Book> getBookList() { return (ArrayList<Book>) this.bookList; }

    public int getCapacity() { return this.capacity.get(); }

    @Override
    public String toString() {
        StringBuilder strBuffer = new StringBuilder("Library: \"");
        strBuffer.append(this.name).append("\"\n");
        for (int i = 0; i < this.capacity.get(); i++) {
            strBuffer.append(this.bookList.get(i).toString()).append('\n');
        }
        return strBuffer.toString();
    }

}
