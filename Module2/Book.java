package Module2;

import java.util.List;
import java.util.Objects;

final class Book {
    private final String name;
    private final String author;
    private final int pages;
    private final int year;

    public Book(String name, String author, int pages, int year) {
        this.name = Objects.requireNonNull(name,"name");
        this.author = Objects.requireNonNull(author,"author");;
        this.pages = pages;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public Book(Book other) {
        this(other.name,other.author, other.pages, other.year);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(pages, book.pages) && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, pages, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                '}';
    }
}
