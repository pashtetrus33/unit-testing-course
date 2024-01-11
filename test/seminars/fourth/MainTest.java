package seminars.fourth;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MainTest {

    /**
     * 4.0 Проверка работы Mockito
     */

    @Test
    void simpleTest() {
        //Cоздаем мок
        List<String> mockedList = mock(List.class);
        //Используем мок
        mockedList.add("one");
        mockedList.clear();

        //Проверяем, что методы были вызваны
        verify(mockedList).add("one");
        verify(mockedList).clear();

    }

    /**
     * 4.1 Создать мок-объект Iterator, настроить поведение так,
     * чтобы за два вызова next() Iterator вернул два слова "Hello World",
     * и проверить это поведение с помощью утверждений
     */

    @Test
    void iteratorWillReturnHelloWorld() {
        //Arrange
        Iterator<String> iteratorMock = mock(Iterator.class);
        //when(iteratorMock.next()).thenReturn("Hello").thenReturn("World");
        when(iteratorMock.next()).thenReturn("Hello", "World");

        //Act
        String res = iteratorMock.next() + iteratorMock.next();
        //Assert
        assertEquals("HelloWorld", res);
    }




    /*
        4.6.Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
        Условие: У вас есть класс Database с методом public List<String> query(String sql),
        который выполняет SQL-запрос и возвращает результат.
        Вам необходимо проверить правильность работы класса DataProcessor, который использует
        Database для выполнения запроса и обработки результатов.

     */
//    public static void main(String[] args) {
//        // Создаём экземпляр класса Database
//        Database database = new Database();
//
//        // Создаём экземпляр класса DataProcessor, передавая в конструктор database
//        DataProcessor dataProcessor = new DataProcessor(database);
//
//        // Вызываем метод processData и выводим результаты
//        List<String> data = dataProcessor.processData("SELECT * FROM table");
//        for (String datum : data) {
//            System.out.println(datum);
//        }
//    }


    /*
     * HW4.3. У вас есть класс BookService, который использует интерфейс BookRepository
     * для получения информации о книгах из базы данных.
     *  Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
     * */
//    public static void main(String[] args) {
//        BookRepository repository = new InMemoryBookRepository();
//        BookService bookService = new BookService(repository);
//
//        Book book1 = bookService.findBookById("1");
//        System.out.println("Найдена книга: " + book1.getTitle() + " by " + book1.getAuthor());
//
//        List<Book> allBooks = bookService.findAllBooks();
//        System.out.println("Все книги:");
//        for (Book book : allBooks) {
//            System.out.println("- " + book.getTitle() + " от " + book.getAuthor());
//        }
//    }
}