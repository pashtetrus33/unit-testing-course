package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {
    // HW 3.1. Нужно покрыть тестами метод на 100%
    // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).


    MainHW mainHW;

    @BeforeEach
    void setup() {
        mainHW = new MainHW();
    }

    /**
     * @param i
     * @apiNote Четное число
     */
    @ParameterizedTest
    @ValueSource(ints = {4, 0, -6})
    void evenNumber(int i) {
        assertTrue(mainHW.isEven(i));
    }

    /**
     * @param i
     * @apiNote Нечетное число
     */

    @ParameterizedTest
    @ValueSource(ints = {3, -23})
    void oddNumber(int i) {
        assertFalse(mainHW.isEven(3));
    }

    // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%

    @ParameterizedTest
    @ValueSource(ints = {26, 99})
    void numberIsInInterval(int i) {
        assertTrue(mainHW.numberInInterval(i));
    }


    @ParameterizedTest
    @ValueSource(ints = {25, 100, -100})
    void numberIsNotInInterval(int i) {
        assertFalse(mainHW.numberInInterval(i));
    }
}
