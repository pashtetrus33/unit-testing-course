package seminars.third.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("прекрасн")) {
            return "GoodMood";
        } else if (message.contains("нормальн") || message.contains("обычн")) {
            return "NormalMood";
        } else {
            return "BadMood";
        }
    }
}