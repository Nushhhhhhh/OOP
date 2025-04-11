package week5;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return "Title: " + title + "\nAuthor: " + author;
    }
}
public class BookShelf {
    public static void main(String[] args) {
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book2 = new Book("Coral Reefs", "C. Darwin");
        Book book3 = new Book("It Ends With Us", "Colleen Hoover");

        System.out.println(book1);
        System.out.println("\n--------------------\n");
        System.out.println(book2);
        System.out.println("\n--------------------\n");
        System.out.println(book3);
    }
}
