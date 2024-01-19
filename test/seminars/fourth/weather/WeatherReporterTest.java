package seminars.fourth.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.fourth.weather.WeatherService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WeatherReporterTest {

    /**
     * 4.3 Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
     * обращающийся к внешнему API для получения информации о текущей температуре.
     * Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
     * Создайте мок-объект для WeatherService с использованием Mockito.
     */
    WeatherService weatherServiceMock;
    WeatherReporter weatherReporter;
    String report;

    @BeforeEach
    void setup() {
        // Arrange
        weatherServiceMock = mock(WeatherService.class);
        weatherReporter = new WeatherReporter(weatherServiceMock);
        when(weatherServiceMock.getCurrentTemperature()).thenReturn(20);
        report = weatherReporter.generateReport();
    }

    @Test
    void setWeatherServiceMethodInvokesOnce() {
        verify(weatherServiceMock, times(1)).getCurrentTemperature();
    }

    @Test
    void weatherReporterReturnsString() {
        assertEquals("Текущая температура: 20 градусов.", report);
    }

    @Test
    void weatherServiceIsNull() {
        weatherReporter = new WeatherReporter(null);
        assertThatThrownBy(()-> weatherReporter.generateReport()).isInstanceOf(NullPointerException.class).hasMessage("WeatherService is null");
    }
}