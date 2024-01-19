package seminars.sixth.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListGeneratorImpl implements ListGenerator {
    Random random = new Random();
    Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public List<Integer> dataGenerate(int size, int max) {

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integerList.add(random.nextInt(max + 1));
        }
        logger.log(Level.INFO, () -> "List: : " + integerList);
        return integerList;
    }
}
