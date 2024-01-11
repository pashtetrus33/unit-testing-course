package seminars.fourth.hotel;

public class BookingService {
    private HotelService hotelService;

    public BookingService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public boolean bookRoom(int roomId) {
        if (hotelService == null){
            throw new NullPointerException("HotelService is null");
        }
        // Код, который бронирует номер.
        // Логика бронирования комнаты
        // В реальном приложении здесь бы было больше кода
        // Номер не доступен
        return hotelService.isRoomAvailable(roomId); // Номер забронирован
    }
}