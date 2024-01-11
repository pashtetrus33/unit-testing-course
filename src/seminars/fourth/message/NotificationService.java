package seminars.fourth.message;

public class NotificationService {

    private MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification(String message, String recipient) {
        if (message == null || recipient == null) {
            throw new NullPointerException("Message or Recipient is null");
        } else if (message.isEmpty() || recipient.isEmpty()) {
            throw new IllegalArgumentException("Message or Recipient is empty");
        } else if (message.isBlank() || recipient.isBlank()) {
            throw new IllegalArgumentException("Message or Recipient is blank");
        }
        messageService.sendMessage(message, recipient);
    }
}
