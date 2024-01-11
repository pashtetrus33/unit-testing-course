package seminars.fourth.hotel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


//*
// 4.4.
//Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
//        Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId), который обычно проверяет, доступен ли номер в отеле.
//Вам необходимо проверить правильность работы класса BookingService, который использует HotelService для бронирования номера, если он доступен.
// *
//    public static void main(String[] args) {
//
//        // Создание реального экземпляра HotelService
//        HotelService realHotelService = new HotelService();
//
//        // Создание экземпляра BookingService с реальным HotelService
//        BookingService bookingService = new BookingService(realHotelService);
//
//        // Пытаемся забронировать доступный номер (например, номер 2)
//        if (bookingService.bookRoom(2)) {
//            System.out.println("Успешно забронирован номер 2!");
//        } else {
//            System.out.println("Не удалось забронировать номер 2.");
//        }
//
//        // Пытаемся забронировать недоступный номер (например, номер 3)
//        if (bookingService.bookRoom(3)) {
//            System.out.println("Успешно забронирован номер 3!");
//        } else {
//            System.out.println("Не удалось забронировать номер 3.");
//        }
//    }
public class BookingServiceTest {

    HotelService hotelServiceMock;
    BookingService bookingService;
    int roomId;

    @BeforeEach
    void setup() {
        // Arrange
        hotelServiceMock = mock(HotelService.class);
        bookingService = new BookingService(hotelServiceMock);
        when(hotelServiceMock.isRoomAvailable(roomId)).thenReturn(true);
        when(hotelServiceMock.isRoomAvailable(1)).thenReturn(false);
        when(hotelServiceMock.isRoomAvailable(3)).thenReturn(false);
        when(hotelServiceMock.isRoomAvailable(5)).thenReturn(false);


        when(hotelServiceMock.isRoomAvailable(2)).thenReturn(true);
        when(hotelServiceMock.isRoomAvailable(6)).thenReturn(true);
        when(hotelServiceMock.isRoomAvailable(8)).thenReturn(true);
    }

    @Test
    void hotelServiceMethodInvokesOnce() {
        bookingService.bookRoom(roomId);
        verify(hotelServiceMock, times(1)).isRoomAvailable(roomId);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 6, 8})
    void bookingServiceReturnsTrue(int n) {
        boolean res = bookingService.bookRoom(n);
        assertTrue(res);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void bookingServiceReturnsFalse(int n) {
        assertFalse(bookingService.bookRoom(n));
    }


    @Test
    void hotelServiceIsNull() {
        bookingService = new BookingService(null);
        assertThatThrownBy(() -> bookingService.bookRoom(roomId)).isInstanceOf(NullPointerException.class).hasMessage("HotelService is null");
    }

    @Test
    void test(){
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(anyInt()))
                .thenAnswer(inv->{
                    int roomNumber= inv.getArgument(0);
                    return roomNumber%2==0;
                });

        assertTrue(bookingService.bookRoom(2));
        assertFalse(bookingService.bookRoom(1));
    }
}

