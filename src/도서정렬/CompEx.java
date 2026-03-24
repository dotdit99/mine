package 도서정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompEx {
    public static void main(String[] args) {
        // 리스트 생성
        List<Book> books = new ArrayList<>();
        // 10개의 도서 객체 생성
        books.add(new Book("해리포터", "J.K. 롤링", 15000, 1997));
        books.add(new Book("어린왕자", "생텍쥐페리", 12000, 1943));
        books.add(new Book("1984", "조지 오웰", 13000, 1949));
        books.add(new Book("동물농장", "조지 오웰", 10000, 1945));
        books.add(new Book("데미안", "헤르만 헤세", 11000, 1919));
        books.add(new Book("노인과 바다", "헤밍웨이", 12000, 1952));
        books.add(new Book("죄와 벌", "도스토예프스키", 18000, 1866));
        books.add(new Book("변신", "프란츠 카프카", 9000, 1915));
        books.add(new Book("파친코", "이민진", 17000, 2017));
        books.add(new Book("채식주의자", "한강", 13000, 2007));
        // 가격 오름 차순 정렬 후 출력
        Collections.sort(books, new Comparator1());
        System.out.println("====가격 오름차순====");
        for (Book book : books) {
            System.out.println(book);
        }
        // 최신 출판 순 정렬 후 출력
        Collections.sort(books, new Comparator2());
        System.out.println("====최신 출판순====");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

// 제목, 저자, 가격, 출판연도
class Book {
    String name;
    String author;
    int price;
    int year;

    // 매개 변수가 있는 생성자
    public Book(String name, String author, int price, int year) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.year = year;
    }

    // toString() 오버라이드
    @Override
    public String toString() {
        return "도서 이름 : " + name + "| 저자 : " + author + "| 가격 : " + price + "| 출판연도 : " + year;
    }
}


// 가격 오름차순: Comparator<Book>
class Comparator1 implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.price > o2.price) { // 정렬 조건
            return 1;
        } else if (o1.price == o2.price) { // 두개의 값이 일치
            return 0;
        } else {
            return -1; // 정렬하지 않는 조건
        }
    }
}

// 출판연도 내림차순: Comparator<Book>
class Comparator2 implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o2.year - o1.year;
    }
}
