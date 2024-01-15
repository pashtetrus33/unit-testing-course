package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {
    private final Random random = new Random();;
    private int size;
    List<Integer> list = new ArrayList<>();

    public RandomNumberModule(int size) {
        this.size = size;
    }

    public RandomNumberModule() {
        this.size = random.nextInt(20);
    }

    public List<Integer> getRandomList() {
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println("Random list: " + list);
        return list;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
