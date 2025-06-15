package cz.czechitas.ukol07.knihovna;

import cz.czechitas.ukol07.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
  private Book book;

  @BeforeEach
  void setUp() {
    book = new Book();
  }

  @Test
  void correctAuthor() {
    book.setAutor("Harry Mulisch");
    assertEquals("Harry Mulisch", book.getAutor());
  }

  @Test
  void incorrectAuthor() {
    assertThrows(IllegalArgumentException.class, () -> book.setAutor(null));
    assertThrows(IllegalArgumentException.class, () -> book.setAutor(""));
  }

  @Test
  void correctTitle() {
    book.setNazev("Atentát");
    assertEquals("Atentát", book.getNazev());
  }

  @Test
  void incorrectTitle() {
    assertThrows(IllegalArgumentException.class, () -> book.setNazev(null));
    assertThrows(IllegalArgumentException.class, () -> book.setNazev(""));
  }

  @Test
  void correctYear() {
    book.setRokVydani(1982);
    assertEquals(1982, book.getRokVydani());
  }

  @Test
  void incorrectYear() {
    assertThrows(IllegalArgumentException.class, () -> book.setRokVydani(1250));
  }

}
