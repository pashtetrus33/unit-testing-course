package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    BookRepository bookRepositoryMock;
    BookService bookService;
    String testId;
    Book testBook;
    List<Book> testBooksList;

    @BeforeEach
    void setup() {
        testId = "1";
        testBook = new Book("1", "TestBook1", "TestAuthor1");
        testBooksList = List.of(testBook);
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
        when(bookRepositoryMock.findById(testId)).thenReturn(testBook);
        when(bookRepositoryMock.findAll()).thenReturn(testBooksList);
    }


    @Test
    public void findByIdMethodTest() {
        Book res = bookService.findBookById(testId);
        assertEquals(testBook, res);
        bookService.findBookById(testId);
    }

    @Test
    public void findAllBooksMethodTest() {
        List<Book> res = bookService.findAllBooks();
        assertEquals(testBooksList, res);
        verify(bookRepositoryMock, times(1)).findAll();
    }
}

