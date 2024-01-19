package seminars.sixth.hw;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ListsProcessorTest {
    ListsProcessor listsProcessor;
    List<Integer> testList1;
    List<Integer> testList2;

    @BeforeEach
    void setUp() {
        testList1 = List.of(1, 1, 1, 1, 1);
        testList2 = List.of(2, 2, 2, 2, 2);
    }

    @Test
    void avgCalculate() {


        listsProcessor = new ListsProcessor(testList1, testList1);
        List<Double> avgList = listsProcessor.avgCalculate();

        assertEquals(1, avgList.get(0));
    }

    @Test
    void avgCompareFirstAvgIsBigger(){
        listsProcessor = new ListsProcessor(testList2, testList1);
        listsProcessor.avgCalculate();
        String result = listsProcessor.avgCompare();
        assertEquals("Первый список имеет большее среднее значение", result);
    }

    @Test
    void avgCompareSecondAvgIsBigger(){
        listsProcessor = new ListsProcessor(testList1, testList2);
        listsProcessor.avgCalculate();
        String result = listsProcessor.avgCompare();
        assertEquals("Второй список имеет большее среднее значение", result);
    }


    @Test
    void avgCompareAvgAreEqual(){
        listsProcessor = new ListsProcessor(testList2, testList2);
        listsProcessor.avgCalculate();
        String result = listsProcessor.avgCompare();
        assertEquals("Средние значения равны", result);
    }

    @Test
    void avgCompareThrowsException(){
        listsProcessor = new ListsProcessor(testList1, testList2);
        assertThatThrownBy(() -> listsProcessor.avgCompare()).isInstanceOf(IllegalArgumentException.class).hasMessage("Средние значения еще не посчитаны!");
    }

    @Test
    void avgCalculateWithNulls() {
        listsProcessor = new ListsProcessor(null, null);
        assertThatThrownBy(() -> listsProcessor.avgCalculate()).isInstanceOf(IllegalArgumentException.class).hasMessage("Списки должны быть не null!");
    }

    @Test
    void avgCompareWithNulls() {
        listsProcessor = new ListsProcessor(testList1, testList2);
        assertThatThrownBy(() -> listsProcessor.avgCompare()).isInstanceOf(IllegalArgumentException.class).hasMessage("Средние значения еще не посчитаны!");
    }
}