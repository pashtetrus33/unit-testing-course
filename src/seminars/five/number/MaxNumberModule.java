package seminars.five.number;

import java.util.Collections;

public class MaxNumberModule {

    private final RandomNumberModule randomNumberModule;

    public MaxNumberModule(RandomNumberModule randomNumberModule) {
        this.randomNumberModule = randomNumberModule;
    }


    public Integer getMaxFromIntegerList() {

        return Collections.max(randomNumberModule.getRandomList());
    }
}
