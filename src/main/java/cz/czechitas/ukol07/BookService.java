package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class BookService {
  private final List<Book> books;

  // class constructor
  public BookService() throws IOException {
    InputStream inputStream = BookService.class.getResourceAsStream("knihy.json");
    ObjectMapper objectMapper = new ObjectMapper();
    try (inputStream) {
      books = objectMapper.readValue(inputStream, new TypeReference<List<Book>>(){});
    }
  }

  public List<Book> getBooks() {
    return books;
  }

  public List<Book> getBooksByAuthor(String author) {
    return books.stream().filter(book -> Objects.equals(book.getAutor(), author)).toList();
  }

  public List<Book> getBooksByYear(int year) {
    return books.stream().filter(book -> Objects.equals(book.getRokVydani(), year)).toList();
  }
}
