package seminars.fourth.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

    /*
      4.5. Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
      Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String recipient),
      который отправляет сообщение получателю.
      Вам необходимо проверить правильность работы класса NotificationService,
      который использует MessageService для отправки уведомлений.
    */
//    public static void main(String[] args) {
//        MessageService messageService = new MessageService();
//        NotificationService notificationService = new NotificationService(messageService);
//
//        notificationService.sendNotification("Привет!", "Анна");
//    }

public class NotificationServiceTest {

    NotificationService notificationService;
    MessageService messageServiceMock;
    String testRecipient;
    String testMessage;

    @BeforeEach
    void setup() {
        testRecipient = "Test";
        testMessage = "Test message";
        messageServiceMock = mock(MessageService.class);
        notificationService = new NotificationService(messageServiceMock);
    }

    @Test
    public void sendMessageMethodInvokedOnce() {
        notificationService.sendNotification(testMessage, testRecipient);

        verify(messageServiceMock, times(1)).sendMessage(testMessage, testRecipient);
    }

    @Test
    public void notificationServiceThrowsNullPointerException() {
        assertThatThrownBy(() -> notificationService.sendNotification(null,null)).isInstanceOf(NullPointerException.class).hasMessage("Message or Recipient is null");
    }

    @Test
    public void sendEmptyArgs() {
        assertThatThrownBy(() -> notificationService.sendNotification("","")).isInstanceOf(IllegalArgumentException.class).hasMessage("Message or Recipient is empty");
    }

    @Test
    public void sendBlankArgs() {
        assertThatThrownBy(() -> notificationService.sendNotification("  "," ")).isInstanceOf(IllegalArgumentException.class).hasMessage("Message or Recipient is blank");
    }
}
