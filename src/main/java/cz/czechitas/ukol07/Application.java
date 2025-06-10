package cz.czechitas.ukol07;

import java.io.IOException;
import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Application {
  public static void main(String[] args) throws IOException {
    BookService bookService = new BookService();

    int bookCount = bookService.getBooks().size();
    System.out.println("Total books available: " + bookCount);

    System.out.println("\n");

    List<Book> booksByKarelCapek = bookService.getBooksByAuthor("Karel Čapek");
    System.out.println("Books written by Karel Čapek:");
    for (Book book : booksByKarelCapek) {
      System.out.println(book.getNazev());
    }

    System.out.println("\n");

    System.out.println("Books written in 1845:");
    List<Book> booksByWrittenIn1845 = bookService.getBooksByYear(1845);
    for (Book book : booksByWrittenIn1845) {
      System.out.println(book.getNazev());
    }

  }
}
