package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    SomeService service;

    // 3.1.
    @BeforeEach
    void setup() {
        service = new SomeService();
    }

    @Test
    void multipleThreeNotFiveReturnsFizz() {
        String res = service.fizzBuzz(12);
        assertEquals("Fizz", res);
    }

    @Test
    void multipleFiveNotThreeReturnsFizz() {
        String res = service.fizzBuzz(10);
        assertEquals("Buzz", res);
    }

    @Test
    void multipleFiveAndThreeReturnsFizzBuzz() {
        String res = service.fizzBuzz(15);
        assertEquals("FizzBuzz", res);
    }

    @Test
    void multipleNotFiveAndNotThreeReturnsInputToString() {
        String res = service.fizzBuzz(7);
        assertEquals("7", res);
    }

    @Test
    void firstDigitIsSix() {
        int[] res = {6, 7, 5, 3, 60};
        assertTrue(service.firstLast6(res));
    }

    @Test
    void lastDigitIsSix() {
        int[] res = {56, 7, 5, 3, 6};
        assertTrue(service.firstLast6(res));
    }

    @Test
    void notFirstNotLastIsSix() {
        int[] res = {56, 7, 5, 3, 60};
        assertFalse(service.firstLast6(res));
    }

    @Test
    void nullPointException() {
        int[] res = null;
        assertThatThrownBy(() -> service.firstLast6(res)).isInstanceOf(NullPointerException.class);
    }

    /**
     * @param i      discount
     * @param result result
     * @apiNote Обычная скидка
     */
    @ParameterizedTest
    @CsvSource({
            "50, 1000",
            "100, 0",
            "0, 2000"
    })
    void correctDiscountCalculatingTest(int i, int result) {
        assertThat(service.calculatingDiscount(2000, i)).isEqualTo(result);
    }

    /**
     * @param i
     * @apiNote Некорректная скидка
     */
    @ParameterizedTest
    @ValueSource(ints = {101, -1})
    void incorrectDiscountValue(int i) {
        assertThatThrownBy(() -> service.calculatingDiscount(2000, i))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }


    @Test
    void incorrectPurchaseAmount() {
        assertThatThrownBy(() -> service.calculatingDiscount(-1, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }


    @Test
    void firstParameterIsThirteen() {
        assertEquals(5, service.luckySum(13, 3, 2));
    }

    @Test
    void secondParameterIsThirteen() {
        assertEquals(3, service.luckySum(1, 13, 2));
    }

    @Test
    void thirdParameterIsThirteen() {
        assertEquals(3, service.luckySum(1, 2, 13));
    }

    @Test
    void nodParameterIsThirteen() {
        assertEquals(14, service.luckySum(1, 2, 11));
    }
}