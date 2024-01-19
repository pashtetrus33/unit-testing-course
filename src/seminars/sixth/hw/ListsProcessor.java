package seminars.sixth.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListsProcessor {

    private final List<Integer> list1;
    private final List<Integer> list2;
    Logger logger = Logger.getLogger(getClass().getName());
    private List<Double> avgResult;

    public ListsProcessor(List<Integer> list1, List<Integer> list2) {

        this.list1 = list1;
        this.list2 = list2;
    }

    public List<Double> avgCalculate() {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException("Списки должны быть не null!");
        }
        avgResult = new ArrayList<>();
        int sumList1 = 0;
        int sumList2 = 0;
        for (int i = 0; i < list1.size(); i++) {
            sumList1 += list1.get(i);
        }
        for (int i = 0; i < list2.size(); i++) {
            sumList2 += list2.get(i);
        }

        avgResult.add(0, ((double) sumList1 / list1.size()));
        avgResult.add(1, ((double) sumList2 / list2.size()));
        logger.log(Level.INFO, () -> "AvgList: " + avgResult);

        return avgResult;
    }

    public String avgCompare() {
        String result;
        if (avgResult != null) {
            if (avgResult.get(0) > avgResult.get(1)) {
                result = "Первый список имеет большее среднее значение";
            } else if (avgResult.get(0) < avgResult.get(1)) {
                result = "Второй список имеет большее среднее значение";
            } else {
                result = "Средние значения равны";
            }
        } else {
            throw new IllegalArgumentException("Средние значения еще не посчитаны!");
        }
        logger.log(Level.INFO, () -> "AVG comparing result: " + result);
        return result;
    }
}
