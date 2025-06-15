package cz.czechitas.ukol07;

public class Book {
  private String autor;
  private String nazev;
  private int rokVydani;

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    if (autor == null || autor.isEmpty()) {
      throw new IllegalArgumentException("Author cannot be null or empty");
    }
    this.autor = autor;
  }

  public String getNazev() {
    return nazev;
  }

  public void setNazev(String nazev) {
    if (nazev == null || nazev.isEmpty()) {
      throw new IllegalArgumentException("Title cannot be null or empty");
    }
    this.nazev = nazev;
  }

  public int getRokVydani() {
    return rokVydani;
  }

  public void setRokVydani(int rokVydani) {
    if (rokVydani < 1440) {
      throw new IllegalArgumentException("Book printing was invented in 1440");
    }
    this.rokVydani = rokVydani;
  }
}
