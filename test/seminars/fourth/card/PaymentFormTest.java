package seminars.fourth.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PaymentFormTest {

    @Test
    void paymentFormWithCreditCardMock() {
        //Arrange
        CreditCard creditCardMock = mock(CreditCard.class);
        PaymentForm paymentForm = new PaymentForm(creditCardMock);
        when(creditCardMock.getCardHolder()).thenReturn("Test Owner");
        double amount = 1000.0;


        //Act
        String owner = creditCardMock.getCardHolder();
        paymentForm.pay(amount);

        //Assert
        assertEquals("Test Owner", owner);
        verify(creditCardMock, times(1)).charge(amount);
    }
}
