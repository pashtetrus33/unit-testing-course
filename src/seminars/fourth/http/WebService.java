package seminars.fourth.http;


public class WebService {

    private final HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String sendRequest(String url) {
        return httpClient.get(url);
    }
}
