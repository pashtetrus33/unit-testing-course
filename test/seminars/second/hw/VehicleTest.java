package seminars.second.hw;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setup() {
        car = new Car("LADA", "XRAY", 2020);
        motorcycle = new Motorcycle("URAL", "EXPEDITION", 2023);
    }

    @Test
    void carInstanceIsVehicleInstance() {

        assertThat(car).isInstanceOf(Vehicle.class);
    }

    @Test
    void carCreatingWithFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void motorcycleCreatingWithTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void carTestDriveSpeedIsSixty() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void motorcycleTestDriveSpeedIsSeventyFive() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void carParkingSpeedIsZero() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void motorcycleParkingSpeedIsZero() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}