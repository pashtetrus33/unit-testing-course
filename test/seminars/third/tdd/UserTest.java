package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    User user;
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        user = new User("user", "password");
        User admin = new User("admin", "qwerty", true);
        User pavel = new User("Pavel", "11111");
        User mariia = new User("Mariia", "abcdef");
        User roman = new User("Roman", "12345");
        userRepository = new UserRepository();
        userRepository.addUser(user);
        userRepository.addUser(admin);
        userRepository.addUser(pavel);
        userRepository.addUser(mariia);
        userRepository.addUser(roman);
    }

    @Test
    void positiveUserData() {

        assertTrue(user.login("user", "password"));
    }

    @ParameterizedTest
    @CsvSource({"root, 1234", "root, password", "user, 1234"})
    void negativeCredentials(String name, String password) {

        assertFalse(user.login(name, password));
    }

    @Test
    void positiveDataForUserRepository() {
        userRepository.addUser(user);
        assertTrue(userRepository.findByName("user"));
    }

    @Test
    void negativeDataForUserRepository() {
        User newUser = new User("Ivan", "1111");
        userRepository.addUser(newUser);
        assertFalse(userRepository.findByName("ivan"));
    }

    @Test
    void removeAllUsers() {
        userRepository.removeAllUsers();
        assertTrue(userRepository.findByName("admin"));

    }
}