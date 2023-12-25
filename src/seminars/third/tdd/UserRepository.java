package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        data.add(user);
    }

    public void removeUser(User user) {
        data.remove(user);
    }

    public void removeAllUsers() {
        data = data.stream().filter(e -> e.isAdmin).collect(Collectors.toList());
    }


    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }
}