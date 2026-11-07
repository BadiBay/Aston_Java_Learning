package Module2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Student {
    private final String name;
    private final List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = Objects.requireNonNull(name,"name");
        Objects.requireNonNull(books, "books");
        if(books.size() < 5){
            throw new IllegalArgumentException("У студента " + name + " должно быть не меньше 5 книг, сйечас: " + books.size());
        }
        this.books = List.copyOf(books);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(books, student.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
