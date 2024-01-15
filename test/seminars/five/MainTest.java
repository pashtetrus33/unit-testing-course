package seminars.five;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MainTest {
    RandomNumberModule randomNumberModule;

    @BeforeEach
    void setup() {
        randomNumberModule = new RandomNumberModule();
    }

    //5.1.
    @Test
    void randomNumberModuleTest() {

        List<Integer> integerList = randomNumberModule.getRandomList();
        assertNotNull(integerList);
        assertTrue(integerList.size() <= 20);
        //assertThat(result)).hasSize(7).isNotEmpty()

    }

    @Test
    void randomNumberModuleTestWithSize() {
        randomNumberModule.setSize(20);
        List<Integer> integerList = randomNumberModule.getRandomList();
        assertNotNull(integerList);
        assertEquals(20, integerList.size());
    }

    @Test
    void getMaxFromListTest() {
        List<Integer> list = List.of(3, 5, 6, 77, 3, 0, 100, 33, 44);
        RandomNumberModule randomNumberModuleMock = mock(RandomNumberModule.class);
        when(randomNumberModuleMock.getRandomList()).thenReturn(list);
        MaxNumberModule maxNumberModule = new MaxNumberModule(randomNumberModuleMock);
        int max = maxNumberModule.getMaxFromIntegerList();
        assertEquals(100, max);
        verify(randomNumberModuleMock, times(1)).getRandomList();
    }

    @Test
    void integrationTest() {
        MaxNumberModule maxNumberModule = new MaxNumberModule(randomNumberModule);
        int max = maxNumberModule.getMaxFromIntegerList();
        assertNotNull(max);
    }

    /*
    * @Test
    void randomNumberTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        List<Double> result = randomNumberModule.generateList(7);
        assertEquals(7, result.size());
        assertThat(result).hasSize(7).isNotEmpty();
    }

    @Test
    void maxNumberListTest() {
        List<Double> doubleList = new ArrayList<>(Arrays.asList(30.0, 3.13, 78.32, 12.01, 132.55));
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        double result = maxNumberModule.findMaxNumberList(doubleList);

        Double expected = Collections.max(doubleList);

        assertEquals(expected, result);


    }

    @Test
    void integrationTest() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Double> randomList = randomNumberModule.generateList(7);
        double result = maxNumberModule.findMaxNumberList(randomList);

        assertEquals(Collections.max(randomList), result);


    }
    * */

    //5.2.

//5.2.

    @ParameterizedTest
    @ValueSource(ints = {2, 5})
    void integrationUserServiceTest(int id) {

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String userName = userService.getUserName(id);
        System.out.println(userName);

        assertThat(userName).isEqualTo("User " + id);
    }

//5.3.

    @Test
    void integrationOrderServiceTest() {

        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        assertTrue(orderService.placeOrder(anyString(), anyDouble()));
        assertTrue(orderService.placeOrder("123444", 100.44));
    }
}