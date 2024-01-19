package seminars.sixth.hw;


import java.util.List;

public class Main {
    public static final int MAX_VALUE = 10;
    public static final int LIST_SIZE = 5;

    public static void main(String[] args) {

        ListGenerator listGenerator = new ListGeneratorImpl();
        List<Integer> list1 = listGenerator.dataGenerate(LIST_SIZE, MAX_VALUE);
        List<Integer> list2 = listGenerator.dataGenerate(LIST_SIZE, MAX_VALUE);
        ListsProcessor listsProcessor = new ListsProcessor(list1, list2);
        listsProcessor.avgCalculate();
        listsProcessor.avgCompare();
    }
}
