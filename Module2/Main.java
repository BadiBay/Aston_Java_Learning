package Module2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Main {
    void main() throws IOException {
        loadStudent(Path.of("StudentsBooks.txt")).stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .distinct()
                .sorted(Comparator.comparingInt(Book::getPages))
                .filter(year -> year.getYear()>2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(year -> System.out.println("Год выпуска найденной книги: " + year), () -> System.out.println("Книга не найдена!"));

    }

    static List<Student> loadStudent (Path path) throws IOException {
        List<Student> students = new ArrayList<>();
        for (String line : Files.readAllLines(path)){
            if (line.isEmpty()){
                continue;
            }
            String [] parts = line.split(";");
            String name = parts[0].strip();

            List<Book> books = new ArrayList<>();
            for (int i = 1; i < parts.length; i++){
                String[] b = parts[i].split(",");
                books.add(new Book(b[0].strip(),b[1].strip(),Integer.parseInt(b[2].strip()),Integer.parseInt(b[3].strip())));
            }
            students.add(new Student(name,books));
        }
        return students;
    }
}
