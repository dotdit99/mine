package 도서관리시스템;

public class Book {
    int isbn; // 고유 도서 번호
    String title; // 도서 제목
    String author; // 저자

    Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public int hashCode() {
        return isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            return this.isbn == ((Book) obj).isbn;
        } else {
            return false;
        }
    }

    public void showBook() {
        System.out.println("ISBN: " + isbn + "\n" + "제목: " + title + "\n" + "저자: " + author + "\n" + "---------------------------------\n");
    }

}

