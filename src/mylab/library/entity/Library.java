package mylab.library.entity;

public class Library {

    private String name;
    private Book[] books;
    private int count;

    // 생성자
    public Library(String name) {
        this.name = name;
        this.books = new Book[100];
        this.count = 0;
    }

    // Getter / Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 도서 추가
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;

            System.out.println("도서가 추가되었습니다: "
                    + book.getTitle());
        } else {
            System.out.println("도서관에 더 이상 도서를 추가할 수 없습니다.");
        }
    }

    // 제목으로 도서 검색
    public Book findBookByTitle(String title) {

        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }

        return null;
    }

    // 저자로 도서 검색
    public Book[] findBooksByAuthor(String author) {

        int resultCount = 0;

        // 검색 결과 개수 확인
        for (int i = 0; i < count; i++) {
            if (books[i].getAuthor().equals(author)) {
                resultCount++;
            }
        }

        // 검색 결과를 저장할 배열 생성
        Book[] result = new Book[resultCount];

        int index = 0;

        for (int i = 0; i < count; i++) {
            if (books[i].getAuthor().equals(author)) {
                result[index] = books[i];
                index++;
            }
        }

        return result;
    }

    // ISBN으로 도서 검색
    public Book findBookByISBN(String isbn) {

        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }

        return null;
    }

    // ISBN으로 도서 대출
    public boolean checkOutBook(String isbn) {

        Book book = findBookByISBN(isbn);

        if (book != null) {
            return book.checkOut();
        }

        return false;
    }

    // ISBN으로 도서 반납
    public boolean returnBook(String isbn) {

        Book book = findBookByISBN(isbn);

        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }

        return false;
    }

    // 대출 가능한 도서 목록
    public Book[] getAvailableBooks() {

        int availableCount = 0;

        // 대출 가능한 도서 개수 확인
        for (int i = 0; i < count; i++) {
            if (books[i].isAvailable()) {
                availableCount++;
            }
        }

        // 대출 가능한 도서를 저장할 배열 생성
        Book[] result = new Book[availableCount];

        int index = 0;

        for (int i = 0; i < count; i++) {
            if (books[i].isAvailable()) {
                result[index] = books[i];
                index++;
            }
        }

        return result;
    }

    // 전체 도서 목록
    public Book[] getAllBooks() {

        Book[] result = new Book[count];

        for (int i = 0; i < count; i++) {
            result[i] = books[i];
        }

        return result;
    }

    // 전체 도서 수
    public int getTotalBooks() {
        return count;
    }

    // 대출 가능한 도서 수
    public int getAvailableBooksCount() {

        int availableCount = 0;

        for (int i = 0; i < count; i++) {
            if (books[i].isAvailable()) {
                availableCount++;
            }
        }

        return availableCount;
    }

    // 대출 중인 도서 수
    public int getBorrowedBooksCount() {
        return count - getAvailableBooksCount();
    }
}
