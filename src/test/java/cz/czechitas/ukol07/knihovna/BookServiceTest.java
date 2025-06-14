package cz.czechitas.ukol07.knihovna;

import cz.czechitas.ukol07.Book;
import cz.czechitas.ukol07.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
  private BookService bookService;

  @BeforeEach
  void setUp() throws IOException {
    bookService = new BookService();
  }

  @Test
  void getBooks() {
    List<Book> result = bookService.getBooks();
    assertFalse(result.isEmpty());
    assertEquals(14, result.size());

    // assertion of the first element of the list
    Book firstBook = result.get(0);
    assertEquals("Božena Němcová", firstBook.getAutor());
    assertEquals("V zámku a podzámčí", firstBook.getNazev());
    assertEquals(1856, firstBook.getRokVydani());
  }

  @Test
  void getBooksByAuthor() {
    List<Book> resultPositive = bookService.getBooksByAuthor("Magdalena Dobromila Rettigová");
    assertFalse(resultPositive.isEmpty());
    assertEquals(2, resultPositive.size());

    List<Book> resultNegative = bookService.getBooksByAuthor("Vladimír Páral");
    assertTrue(resultNegative.isEmpty());
  }

  @Test
  void getBooksByYear() {
    List<Book> resultPositiveOneBook = bookService.getBooksByYear(1937);
    assertFalse(resultPositiveOneBook.isEmpty());
    assertEquals(1, resultPositiveOneBook.size());
    assertEquals("Bílá nemoc", resultPositiveOneBook.get(0).getNazev());

    List<Book> resultPositiveTwoBooks = bookService.getBooksByYear(1856);
    assertFalse(resultPositiveTwoBooks.isEmpty());
    assertEquals(2, resultPositiveTwoBooks.size());
    assertEquals("V zámku a podzámčí", resultPositiveTwoBooks.get(0).getNazev());
    assertEquals("Divá Bára", resultPositiveTwoBooks.get(1).getNazev());

    List<Book> resultNegative = bookService.getBooksByYear(1967);
    assertTrue(resultNegative.isEmpty());
  }

}
