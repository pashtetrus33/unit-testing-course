package seminars.fourth.http;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WebServiceTest {
    WebService webService;
    HttpClient httpClientMock;
    String testUrl;
    String testAnswer;


    @BeforeEach
    void setup() {
        testUrl = "https://www.test.com";
        testAnswer = "test http client answer";
        httpClientMock = mock(HttpClient.class);
        webService = new WebService(httpClientMock);
        when(httpClientMock.get(anyString())).thenReturn(testAnswer);
    }

    @Test
    public void getMethodInvokedOnce() {
        webService.sendRequest(testUrl);
        verify(httpClientMock, times(1)).get(testUrl);
    }

    @Test
    public void sendRequestMethodTest() {
        String res = webService.sendRequest(testUrl);
        assertEquals(testAnswer, res);
    }
}